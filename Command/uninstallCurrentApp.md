```bat
@echo off
::set window charset utf-8
CHCP 65001 >nul
adb get-state >nul
adb wait-for-device
FOR /F "tokens=3 delimes=/ " %%i IN ('adb shell dumpsys window ^| findstr mCurrentFocus') do call :sub %%i
::restult
goto end

:sub
set /p input="是否卸载当前应用（y确定）："
echo %input%|findstr "y" >nul
if %errorlevel% equ 0(
	adb uninstall %1
) else (
	echo 取消卸载！
)
goto :eof

:end

```

