```
@echo off
set /p file="Please input your Rpk path:"
call :sub %file%
goto end

:sub
adb push %1 sdcard/Downloads/
adb shell am broadcast -a android.intent.action.media_scanner_scan_file -d file:///sdcard/Download/%~nx1
goto :eof

:end
```

