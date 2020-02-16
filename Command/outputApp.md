```bat
@echo off
set /p filter="Filter package name: "
adb shell pm list packages -f %filter%
set /p package="Please enter the name of the apk package to be exported: "
FOR /F "tokens=2 delims=:" %%i IN ('adb shell pm path %package%') do call :sub "%%i"
echo ------------------end------------------
goto end

:sub
adb pull %1  %USERPROFILE%\desktop
goto :eof

:end

```

