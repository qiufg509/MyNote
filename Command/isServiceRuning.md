```bat
@echo off
adb get-state >nul
adb wait-for-device
set /p package="Please enter the package name:"
adb shell dumpsys activity services %package%
```

