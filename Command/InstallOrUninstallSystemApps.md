```bat
@echo off
adb get-state >nul
adb wait-for-device
adb root
adb remount
set /p apkFile="Please enter the APK file path:"
rem Compress software path.
set 7zip=C:\Progra~1\7-Zip\7z
rem Temporary decompression path.
set unzip_tmp=%USERPROFILE%\desktop\.tmp
rem CPU model
set cpu=x86_64
rd /s/q %unzip_tmp%
md %unzip_tmp%
%7zip% x -o%unzip_tmp% %apkFile%
choice /N /C IU /M "[I]nstall or [U]ninstall?"
if %errorlevel% == 1 call :install %apkFile% %unzip_tmp% %cpu%
if %errorlevel% == 2 call :uninstall %apkFile% %unzip_tmp% %cpu%
rd /s/q %unzip_tmp%
goto end

:install
adb push %1 /system/priv-app
adb push %2\lib\%3\. /system/lib64
goto :eof

:uninstall
set cmd=%USERPROFILE%\desktop\.sh
echo rm /system/priv-app/%~nx1 >%cmd%
for /R %2\lib\%3 %%i IN (*.*) do echo rm /system/lib64/%%~nxi >>%cmd%
echo exit >>%cmd%
adb shell <%cmd%
del %cmd%
goto :eof

:end
```

