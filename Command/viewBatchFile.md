```batch
echo.
choice /C ABCDEFGHIJKL1 /N /M "Please select a batch file to view:"
if %errorlevel% == 1 type %CD%\outputApp.bat
if %errorlevel% == 2 type %CD%\outputDB.bat
if %errorlevel% == 3 type %CD%\uninstallCurrentApp.bat
if %errorlevel% == 4 type %CD%\pushFileIntoSDCard.bat
if %errorlevel% == 5 type %CD%\getInfoFromApk.bat
if %errorlevel% == 6 type %CD%\isServiceRuning.bat
if %errorlevel% == 7 type %CD%\MD5_SHA1_SHA256.bat
if %errorlevel% == 8 type %CD%\startEmulator.bat
if %errorlevel% == 9 type %CD%\360jg_channel.bat
if %errorlevel% == 10 type %CD%\Screenshot_ScreenRecording.bat
if %errorlevel% == 11 type %CD%\startFastApp.bat
if %errorlevel% == 12 type %CD%\portOccupationQuery.bat
if %errorlevel% == 13 type %CD%\viewBatchFile.bat
```

