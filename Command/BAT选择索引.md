```
@echo off
::Set the window's encoding format to UTF-8
CHCP 65001 >nul
:start
call :tips
choice /C abcdefghij /M "Please select:"
if %errorlevel% == 1 call %CD%\outputApp.bat
if %errorlevel% == 2 call %CD%\outputDB.bat
if %errorlevel% == 3 call %CD%\uninstallCurrentApp.bat
if %errorlevel% == 4 call %CD%\pushFileIntoSDCard.bat
if %errorlevel% == 5 call %CD%\getInfoFromApk.bat
if %errorlevel% == 6 call %CD%\isServiceRuning.bat
if %errorlevel% == 7 call %CD%\MD5_SHA1_SHA256.bat
if %errorlevel% == 8 call %CD%\startEmulator.bat
if %errorlevel% == 9 call %CD%\360jg_channel.bat
if %errorlevel% == 10 call %CD%\Screenshot_ScreenRecording.bat
rem set /p opt="Please select an operation:"
::if "%opt%" == "A" (
::	call %CD%\outputApp.bat
::) else if "%opt%" == "B" (
::	call %CD%\outputDB.bat
::) else if "%opt%" == "C" (
::	call %CD%\uninstallCurrentApp.bat
::) else if "%opt%" == "D" (
::	call %CD%\pushFileIntoSDCard.bat
::) else if "%opt%" == "E" (
::	call %CD%\getInfoFromApk.bat
::) else if "%opt%" == "F" (
::	call %CD%\isServiceRuning.bat
::) else if "%opt%" == "G" (
::	call %CD%\MD5_SHA1_SHA256.bat
::) else if "%opt%" == "H" (
::	call %CD%\startEmulator.bat
::) else if "%opt%" == "I" (
::	call %CD%\360jg_channel.bat
::) else if "%opt%" == "J" (
::	call %CD%\Screenshot_ScreenRecording.bat
::) else (
::	goto start
::)
goto exit

rem operation menu
:tips
echo=
echo ---------- operation menu ----------
echo A.Output Apk
echo B.Output database
echo C.Uninstall current App
echo D.Push file into SDCard
echo E.Get Info from Apk
echo F.Is service runing
echo G.Get file's MD5_SHA1_SHA256
echo H.Start emulator in writable mode
echo I.AndGuard_360JG_walle
echo J.Screenshot or ScreenRecording
echo\
goto :eof

rem exit
:exit
set /p exit="Enter q to exit,otherwise continue!"
::Multiple ways to output blank lines
echo=
echo,
echo;
echo+
echo/
echo[
echo]
echo:
echo.
echo\
if "%exit%" equ "q" (
	goto end
) else (
	goto start
)
goto :eof


:end

```

