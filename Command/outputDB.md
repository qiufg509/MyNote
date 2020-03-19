前提APP为debugable模式

```bat
@echo off
adb get-state >nul
adb wait-for-device
set /p package="Please enter the package name:"
set cmd=%USERPROFILE%\Desktop\.com.sh
set desDir=/sdcard/%package%
echo rm -rf %desDir% >%cmd%
echo mkdir %desDir% >>%cmd%
rem 如果dir2目录不存在，则可以直接使用cp -r dir1 dir2
rem 如果目录已存在，则需要使用cp -r dir1/. dir2
rem 过滤*.db而不全部copy故创建目标文件
echo mkdir %desDir%/databases/ >>%cmd%
rem 
echo run-as %package% >>%cmd%
::echo su root >>%cmd% rem 真机没权限
echo cp -r /data/data/%package%/databases/*.db %desDir%/databases >>%cmd%
echo cp -r /data/data/%package%/shared_prefs/ %desDir%/shared_prefs >>%cmd%
echo exit >>%cmd%
echo exit >>%cmd%
adb shell < %cmd%
del %cmd%
adb pull %desDir% %userprofile%/desktop
adb shell rm -rf  %desDir%
echo ---------- done ----------
```

