@echo off

choice 
if "%time:~0,1"==" " (
	adb pull /sdcard/screenshot.png %USERPROFILE%\desktop\%date:0,4%%date:~5,2%%date:~8,2%0%time:~1,1%%time:~3,2%%time:~6,2%.png
) else (
	adb pull /sdcard/screenshot.png %USERPROFILE%\desktop\%date:0,4%%date:~5,2%%date:~8,2%%time:~0,1%%time:~1,1%%time:~3,2%%time:~6,2%.png
)
adb shell rm /sdcard/screenshot.png
goto end

:ScreenRecording
adb shell screenrecord /sdcard/screenrecord.mp4 >nul
if %errorlevel%==127 goto ScrcpyRecording
echo Automatically export video to desktop after 3 second... & ping /n 3 127.0.0.1 >nul
if "%time:~0,1"==" " (
	adb pull /sdcard/screenrecord.mp4 %USERPROFILE%\desktop\%date:0,4%%date:~5,2%%date:~8,2%0%time:~1,1%%time:~3,2%%time:~6,2%.mp4
) else (
	adb pull /sdcard/screenrecord.mp4 %USERPROFILE%\desktop\%date:0,4%%date:~5,2%%date:~8,2%%time:~0,1%%time:~1,1%%time:~3,2%%time:~6,2%.mp4
)
adb shel rm /sdcard/screenrecord.mp4
got end

:ScrcpyRecording
set scrcpy=E:\Soft\scrcpy\
cd /d %scrcpy%
scrcpy -Nr screenrecord.mkv
if "%time:~0,1"==" " (
	move %scrcpy%\screenrecord.mkv %USERPROFILE%\desktop\%date:0,4%%date:~5,2%%date:~8,2%0%time:~1,1%%time:~3,2%%time:~6,2%.mkv
) else (
	move %scrcpy%\screenrecord.mkv %USERPROFILE%\desktop\%date:0,4%%date:~5,2%%date:~8,2%%time:~0,1%%time:~1,1%%time:~3,2%%time:~6,2%.mkv
)
goto end

:end