前提APP为debugable模式

```
@echo off
adb devices
set /p deviceId="Please enter the device ID: "
set /p package="Please enter the package name: "
set /p db="Please enter the DB name: "
set cmdFile=%USERPROFILE%\Desktop\.cmd.sh
echo run-as %package% >%cmdFile%
echo touch /sdcard/%db% >>%cmdFile%
echo cat /data/data/%package%/databases/%db% ^> /sdcard/%db% >>%cmdFile%
echo exit >>%cmdFile%
echo exit >>%cmdFile%
adb -s %deviceId% shell < %cmdFile%
del %cmdFile%
adb -s %deviceId% pull /sdcard/%db% %USERPROFILE%\Desktop
adb -s %deviceId% shell rm /sdcard/%db%

pause
```

