```bat
@echo off
adb get-state >nul
adb wait-for-device
set /p filter="Filter package name: "
adb shell pm list packages -f %filter%
set /p package="Please enter the name of the apk package to be exported: "
FOR /F "tokens=2 delims=:" %%i IN ('adb shell pm path %package%') do call :sub "%%i" %package%
echo ------------------end------------------
goto end

:sub
adb pull %1 %USERPROFILE%\desktop\%2%~x1
goto :eof

:end

```

