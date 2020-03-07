```bat
@echo off
rem CHCP 65001 error date time
CHCP 936 >nul
adb get-state >nul
adb wait-for-device
:begin
echo 1.Screenshot
echo 2.Screen recording
echo 3.Export screen recording file
echo Q.exit
choice /C 123q /M "Please select:"
if %errorlevel%==1 goto one
if %errorlevel%==2 goto two
if %errorlevel%==3 goto three
if %errorlevel%==4 goto end

:one
adb shell /system/bin/screencap -p /sdcard/screenshot.png
if "%time:~0,1%"==" " (
	adb pull /sdcard/screenshot.png %USERPROFILE%\desktop\%date:~0,4%%date:~5,2%%date:~8,2%0%time:~1,1%%time:~3,2%%time:~6,2%.png
) else (
	adb pull /sdcard/screenshot.png %USERPROFILE%\desktop\%date:~0,4%%date:~5,2%%date:~8,2%%time:~0,1%%time:~1,1%%time:~3,2%%time:~6,2%.png
)
adb shell rm /sdcard/screenshot.png
goto begin

:two
adb shell screenrecord /sdcard/screenrecord.mp4
goto begin

:three
if "%time:~0,1%"==" " (
	adb pull /sdcard/screenrecord.mp4 %USERPROFILE%\desktop\%date:~0,4%%date:~5,2%%date:~8,2%0%time:~1,1%%time:~3,2%%time:~6,2%.mp4
) else (
	adb pull /sdcard/screenrecord.mp4 %USERPROFILE%\desktop\%date:~0,4%%date:~5,2%%date:~8,2%%time:~0,1%%time:~1,1%%time:~3,2%%time:~6,2%.mp4
)
adb shell rm /sdcard/screenrecord.mp4
goto begin

:end
```

