```bat
@echo off
::Set the window's encoding format to UTF-8
CHCP 65001 >nul
goto start_2
:start_1
call :blank
:start_2
call :tips
choice /C abcdefghijklmnVQ /CS /N /M "Please select:"
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
if %errorlevel% == 13 call %CD%\InstallOrUninstallSystemApps.bat
if %errorlevel% == 14 call %CD%\modifyApk.bat
if %errorlevel% == 15 call %CD%\viewBatchFile.bat
if %errorlevel% == 16 goto :exit
goto start_1

rem operation menu
:tips
echo=
echo ---------- operation menu ----------
echo a. Output Apk
echo b. Output database
echo c. Uninstall current App
echo d. Push file into SDCard
echo e. Get Info from Apk
echo f. Is service runing
echo g. Get file's MD5_SHA1_SHA256
echo h. Start emulator in writable mode
echo i. AndGuard_360JG_walle
echo j. Screenshot or ScreenRecording
echo k. start FastApp on loader
echo l. ADB Port Occupation Query
echo m. Install Or Uninstall System Apps
echo n. modify Apk
echo V. View Batch File
echo Q. Exit
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

