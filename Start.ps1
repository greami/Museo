$ErrorActionPreference = 'Stop'

function Read-PersistentJwtSecret {
  param([string]$Path)

  for ($attempt = 0; $attempt -lt 20; $attempt++) {
    try {
      $secret = [System.IO.File]::ReadAllText($Path).Trim()
      if (-not [string]::IsNullOrWhiteSpace($secret)) {
        return $secret
      }
    } catch [System.IO.IOException] {
    }

    Start-Sleep -Milliseconds 100
  }

  throw "JWT secret file is empty or unavailable: $Path"
}

function Get-PersistentJwtSecret {
  if (-not $env:USERPROFILE) {
    throw 'USERPROFILE is not set; cannot store the JWT secret.'
  }

  $secretDirectory = Join-Path $env:USERPROFILE '.museo'
  $secretFile = Join-Path $secretDirectory 'jwt-secret'
  if (Test-Path -LiteralPath $secretFile -PathType Leaf) {
    return Read-PersistentJwtSecret -Path $secretFile
  }

  New-Item -ItemType Directory -Path $secretDirectory -Force | Out-Null
  $randomBytes = New-Object byte[] 64
  $randomGenerator = [System.Security.Cryptography.RandomNumberGenerator]::Create()
  try {
    $randomGenerator.GetBytes($randomBytes)
    $secret = [Convert]::ToBase64String($randomBytes)
  } finally {
    $randomGenerator.Dispose()
  }

  $stream = $null
  try {
    $stream = [System.IO.File]::Open(
      $secretFile,
      [System.IO.FileMode]::CreateNew,
      [System.IO.FileAccess]::Write,
      [System.IO.FileShare]::None
    )
    $secretBytes = [System.Text.Encoding]::ASCII.GetBytes($secret + [Environment]::NewLine)
    $stream.Write($secretBytes, 0, $secretBytes.Length)
  } catch [System.IO.IOException] {
    if ($null -eq $stream -and (Test-Path -LiteralPath $secretFile -PathType Leaf)) {
      return Read-PersistentJwtSecret -Path $secretFile
    }
    throw
  } finally {
    if ($null -ne $stream) {
      $stream.Dispose()
    }
  }

  Write-Host "JWT_SECRET generated and saved to $secretFile."
  return $secret
}

if ([string]::IsNullOrWhiteSpace($env:JWT_SECRET)) {
  $env:JWT_SECRET = Get-PersistentJwtSecret
}

$script:StopRequested = $false
$root = $PSScriptRoot
$uiDir = Join-Path $root 'UIApp'
$ports = @(8082, 8084, 8080, 5173)
$startedServices = @()
$exitCode = 0

function Test-LocalPort {
  param([int]$Port)

  $client = New-Object System.Net.Sockets.TcpClient
  try {
    $result = $client.BeginConnect('127.0.0.1', $Port, $null, $null)
    if (-not $result.AsyncWaitHandle.WaitOne(250)) {
      return $false
    }

    $client.EndConnect($result)
    return $true
  } catch [System.Net.Sockets.SocketException] {
    return $false
  } finally {
    $client.Close()
  }
}

function Wait-ForPort {
  param(
    [int]$Port,
    [string]$Name,
    [System.Diagnostics.Process]$Process
  )

  $deadline = (Get-Date).AddMinutes(4)
  while ((Get-Date) -lt $deadline) {
    if ($script:StopRequested) {
      return
    }

    $Process.Refresh()
    if ($Process.HasExited) {
      throw "$Name exited before opening port $Port (exit code $($Process.ExitCode))."
    }
    if (Test-LocalPort -Port $Port) {
      return
    }
    Start-Sleep -Seconds 2
  }

  throw "Timed out waiting for $Name on port $Port."
}

function Stop-StartedServices {
  foreach ($entry in $startedServices) {
    $entry.Process.Refresh()
    if (-not $entry.Process.HasExited) {
      Write-Host "Stopping $($entry.Name)..."
      & "$env:SystemRoot\System32\taskkill.exe" /PID $entry.Process.Id /T /F | Out-Null
    }
  }
}

$cancelHandler = [System.ConsoleCancelEventHandler] {
  param($sender, $eventArgs)
  $eventArgs.Cancel = $true
  $script:StopRequested = $true
}

try {
  [Console]::add_CancelKeyPress($cancelHandler)

  foreach ($port in $ports) {
    if (Test-LocalPort -Port $port) {
      throw "Port $port is already in use; stop its existing service before starting this stack."
    }
  }

  $services = @(
    [pscustomobject]@{
      Name = 'user-service'
      Port = 8082
      Directory = (Join-Path $root 'user-service')
      Command = 'mvn -f pom.xml -pl adapter -am install -DskipTests && mvn -f adapter\pom.xml spring-boot:run -Dspring-boot.run.main-class=org.user.service.Start'
    },
    [pscustomobject]@{
      Name = 'core-service'
      Port = 8084
      Directory = (Join-Path $root 'core-service')
      Command = 'mvn -f pom.xml -pl adapter -am install -DskipTests && mvn -f adapter\pom.xml spring-boot:run -Dspring-boot.run.main-class=org.core.Start'
    },
    [pscustomobject]@{
      Name = 'api-gateway'
      Port = 8080
      Directory = (Join-Path $root 'api-gateway')
      Command = 'mvn -f pom.xml -pl adapter -am install -DskipTests && mvn -f adapter\pom.xml spring-boot:run -Dspring-boot.run.main-class=org.api.gateway.Start'
    },
    [pscustomobject]@{
      Name = 'UIApp'
      Port = 5173
      Directory = $uiDir
      Command = 'npm run build && npm run dev -- --host 0.0.0.0'
    }
  )

  if (-not (Test-Path (Join-Path $uiDir 'node_modules'))) {
    Write-Host 'Installing UIApp dependencies...'
    Push-Location $uiDir
    try {
      & npm ci
      if ($LASTEXITCODE -ne 0) {
        throw "npm ci failed with exit code $LASTEXITCODE."
      }
    } finally {
      Pop-Location
    }
  }

  foreach ($service in $services) {
    if ($script:StopRequested) {
      break
    }

    Write-Host "Starting $($service.Name)..."
    $command = '/c "title ' + $service.Name + ' && ' + $service.Command + '"'
    $process = Start-Process -FilePath $env:ComSpec -ArgumentList $command -WorkingDirectory $service.Directory -PassThru -WindowStyle Normal
    $startedServices += [pscustomobject]@{
      Name = $service.Name
      Process = $process
    }
    Wait-ForPort -Port $service.Port -Name $service.Name -Process $process
  }

  if (-not $script:StopRequested) {
    Write-Host 'All services are running. Press Ctrl+C to stop them.'
    while (-not $script:StopRequested) {
      foreach ($entry in $startedServices) {
        $entry.Process.Refresh()
        if ($entry.Process.HasExited) {
          throw "$($entry.Name) exited unexpectedly (exit code $($entry.Process.ExitCode))."
        }
      }
      Start-Sleep -Seconds 1
    }
  }
} catch {
  Write-Error $_ -ErrorAction Continue
  $exitCode = 1
} finally {
  Stop-StartedServices
  [Console]::remove_CancelKeyPress($cancelHandler)
}

exit $exitCode
