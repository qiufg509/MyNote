```bat
@echo off
adb devices
set /p deviceId="Please enter the device ID: "
set /p filter="Filter package name: "
adb -s %deviceId% shell pm list packages %filter%
set /p package="Please enter the name of the apk package to be exported: "
FOR /F "tokens=2 delims=:" %%i IN ('adb -s %deviceId% shell pm path %package%') do call :sub "%%i"
echo ------------------end------------------
goto end

:sub
adb -s %deviceId% pull %1  %USERPROFILE%\desktop
goto :eof

:end
pause
```

