```
@echo off
set /p apkPath="Please enter the APK file path:"
%ANDROID_HOME%\build-tools\29.0.2\aapt.ext dumpsys badging %apkPath% | findstr package
```

