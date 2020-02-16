```
@echo off
set /p package="Please enter the package name:"
adb shell dumpsys activity services %package%
```

