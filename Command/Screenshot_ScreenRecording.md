```
@echo off
:begin
echo 1.Screenshot
echo 2.Screen recording
echo 3.Export screen recording file
echo q.exit
choice /C 123q /M "Please select:"
if %errorlevel%==1 goto one
if %errorlevel%==2 goto two
if %errorlevel%==3 goto three
if %errorlevel%==4 goto end

:one
adb shell /system/bin/screencap -p /sdcard/screenshot.png
adb pull /sdcard/screenshot.png %USERPROFILE%\desktop\
adb shell rm /sdcard/screenshot.png
goto begin

:two
adb shell screenrecord /sdcard/demo.mp4
goto begin

:three
adb pull /sdcard/demo.mp4 %USERPROFILE%\desktop\
adb shell rm /sdcard/demo.mp4
goto begin

:end

```

