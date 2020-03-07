```bat
@echo off
set emulatorPath="ANDROID_HOME"\emulator
rem 模拟器有空格用"_"替换，有下划线需要转义
%emulatorPath%\emulator.exe -avd Polestar1 -writable-system
```

