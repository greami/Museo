@echo off
setlocal EnableExtensions

set "ROOT=%~dp0"
if not defined AUTH_COOKIE_SECURE set "AUTH_COOKIE_SECURE=false"
if not defined JWT_SECRET (
  for /f "delims=" %%i in ('powershell -NoProfile -Command "$b = New-Object byte[] 64; (New-Object System.Security.Cryptography.RNGCryptoServiceProvider).GetBytes($b); [Convert]::ToBase64String($b)"') do set "JWT_SECRET=%%i"
  echo JWT_SECRET non impostata: generato un segreto temporaneo ^(i token si invalidano al riavvio^).
)

powershell -NoProfile -ExecutionPolicy Bypass -File "%ROOT%Start.ps1"
exit /b %errorlevel%
