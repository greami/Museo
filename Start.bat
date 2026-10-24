@echo off
setlocal EnableExtensions EnableDelayedExpansion

set "ROOT=%~dp0"
set "UI_DIR=%ROOT%UIApp"

if not defined AUTH_COOKIE_SECURE set "AUTH_COOKIE_SECURE=false"
if not defined JWT_SECRET (
  for /f "delims=" %%i in ('powershell -NoProfile -Command "$b = New-Object byte[] 64; (New-Object System.Security.Cryptography.RNGCryptoServiceProvider).GetBytes($b); [Convert]::ToBase64String($b)"') do set "JWT_SECRET=%%i"
  echo JWT_SECRET non impostata: generato un segreto temporaneo ^(i token si invalidano al riavvio^).
)

call :start_service "user-service" "%ROOT%user-service" "mvn -f pom.xml -pl adapter -am clean package -DskipTests && mvn -f adapter\pom.xml spring-boot:run -Dspring-boot.run.main-class=org.user.service.Start"
call :wait_for_port 8082 user-service || exit /b 1

call :start_service "core-service" "%ROOT%core-service" "mvn -f pom.xml -pl adapter -am clean package -DskipTests && mvn -f adapter\pom.xml spring-boot:run -Dspring-boot.run.main-class=org.core.Start"
call :wait_for_port 8084 core-service || exit /b 1

call :start_service "api-gateway" "%ROOT%api-gateway" "mvn -f pom.xml -pl adapter -am clean package -DskipTests && mvn -f adapter\pom.xml spring-boot:run -Dspring-boot.run.main-class=org.api.gateway.Start"
call :wait_for_port 8080 api-gateway || exit /b 1

if not exist "%UI_DIR%\node_modules" (
  pushd "%UI_DIR%"
  call npm ci
  if errorlevel 1 (
    popd
    exit /b 1
  )
  popd
)

call :start_service "UIApp" "%UI_DIR%" "npm run build && npm run dev -- --host 0.0.0.0"
call :wait_for_port 5173 UIApp || exit /b 1

echo All services are running.
exit /b 0

:start_service
set "NAME=%~1"
set "DIR=%~2"
set "COMMAND=%~3"
start "%NAME%" cmd /k "cd /d %DIR% && %COMMAND%"
exit /b 0

:wait_for_port
set "PORT=%~1"
set "NAME=%~2"
powershell -NoProfile -Command "$deadline = (Get-Date).AddMinutes(4); while ((Get-Date) -lt $deadline) { if (Test-NetConnection -ComputerName 127.0.0.1 -Port %PORT% -InformationLevel Quiet) { exit 0 }; Start-Sleep -Seconds 2 }; Write-Error ('Timed out waiting for %NAME% on port %PORT%'); exit 1"
exit /b %errorlevel%
