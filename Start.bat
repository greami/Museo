@echo off
setlocal EnableExtensions

set "ROOT=%~dp0"
if not defined AUTH_COOKIE_SECURE set "AUTH_COOKIE_SECURE=false"

pushd "%ROOT%"
powershell -NoLogo -NoProfile -ExecutionPolicy Bypass -File "%ROOT%Start.ps1"
set "EXIT_CODE=%errorlevel%"
popd
exit /b %EXIT_CODE%
