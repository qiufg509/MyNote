```bat
@echo off
::Set the window's encoding format to UTF-8
CHCP 65001 >nul
goto start_2
:start_1
call :blank
:start_2
call :tips
choice /C ABCDEFGHIJKL10 /N /M "Please select:"
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
if %errorlevel% == 11 call %CD%\startFastApp.bat
if %errorlevel% == 12 call %CD%\portOccupationQuery.bat
if %errorlevel% == 13 call %CD%\viewBatchFile.bat
if %errorlevel% == 14 goto :exit
goto start_1

rem operation menu
:tips
echo=
echo ---------- operation menu ----------
echo A. Output Apk
echo B. Output database
echo C. Uninstall current App
echo D. Push file into SDCard
echo E. Get Info from Apk
echo F. Is service runing
echo G. Get file's MD5_SHA1_SHA256
echo H. Start emulator in writable mode
echo I. AndGuard_360JG_walle
echo J. Screenshot or ScreenRecording
echo K. start FastApp on loader
echo L. ADB Port Occupation Query
echo 1. View Batch File
echo 0. Exit
echo\
goto :eof

rem exit
:blank
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
goto :eof

:exit
```

