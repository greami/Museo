@echo off
setlocal EnableExtensions

set "ROOT=%~dp0"
if not defined AUTH_COOKIE_SECURE set "AUTH_COOKIE_SECURE=false"

powershell -NoProfile -ExecutionPolicy Bypass -File "%ROOT%Start.ps1"
exit /b %errorlevel%
