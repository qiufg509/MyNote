前提APP为debugable模式

```bat
@echo off
adb get-state >nul
adb wait-for-device
set /p package="Please enter the package name:"
set /p db="Please enter the DB name:"
set cmdFile=%USERPROFILE%\Desktop\.com.sh
echo run-as %package% > %cmdFile%
echo touch /SDCard/%db% >> %cmdFile%
echo cat /data/data/%package%/databases/%db% ^> /SDCard/%db% >> %cmdFile%
echo eixt >> %cmdFile%
echo eixt >> %cmdFile%
adb shell < %cmdFile%
del %cmdFile%
adb pull /SDCard/%db% %USERPROFILE%\Desktop\
adb shell rm /SDCard/%db%
```

