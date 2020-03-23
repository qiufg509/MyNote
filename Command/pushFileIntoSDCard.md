```bat
@echo off
adb get-state >nul
adb wait-for-device
set /p file="Please input your file path:"
call :sub %file%
goto end

:sub
adb push %1 sdcard/Download/
adb shell am broadcast -a android.intent.action.MEDIA_SCANNER_SCAN_FILE -d file:///sdcard/Download/%~nx1
goto :eof

:end
```

