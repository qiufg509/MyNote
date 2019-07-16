#### connect to PC

```bat
@echo off

echo @echo off > %cd%\doConnect.bat
echo set ip=%%1 >> %cd%\doConnect.bat
echo if "%%ip%%"=="" goto end >> %cd%\doConnect.bat
echo for /f "delims= " %%%%i in ('adb connect %%ip%%') do ( >> %cd%\doConnect.bat
echo 	if not "%%%%i"=="connected" ( >> %cd%\doConnect.bat
echo 		echo unable to connect to %%ip%% >> %cd%\doConnect.bat
echo 		goto end >> %cd%\doConnect.bat
echo 	) >> %cd%\doConnect.bat
echo ) >> %cd%\doConnect.bat
echo adb root >> %cd%\doConnect.bat
echo timeout /t 10 /nobreak >> %cd%\doConnect.bat
echo adb remount >> %cd%\doConnect.bat
echo adb shell "echo 2 > /sys/bus/platform/drivers/usb20_otg/force_usb_mode" >> %cd%\doConnect.bat
echo adb disconnect %%ip%% >> %cd%\doConnect.bat
echo :end >> %cd%\doConnect.bat

set /p ip="Device IP = "
if "%ip%"=="" (
	for /f "skip=3 delims= " %%i in ('arp -a') do (
		call %cd%\doConnect.bat %%i
	)
) else (
	call %cd%\doConnect.bat %ip%
)

pause
```

#### connect to PC（优化版）

```bat
@echo off

set /p ip="Device IP = "
if "%ip%"=="" (
	for /f "skip=3 delims= " %%i in ('arp -a') do (
		call :sub %%i
	)
) else (
	call call :sub %ip%
)

pause
exit

rem -------------------------------------------------------------------------

:sub
set ip=%1
if "%ip%"=="" goto end
for /f "delims= " %%i in ('adb connect %%ip%%') do (
	if "%%i"=="unable" (
		echo Unable to connect to Computer %ip%
		goto endSub
	)
)
adb root
timeout /t 10 >nul
adb remount  >nul
set usb_conf=/sys/bus/platform/drivers/usb20_otg/force_usb_mode
adb shell "echo 2 > %usb_conf%"  >nul
adb root
adb disconnect %ip%  >nul
timeout /t 2  >nul
adb remount  >nul

:endSub
goto :eof
```

