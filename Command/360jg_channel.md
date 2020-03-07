#### 多个渠道包分别处理

```bat
@echo off
adb get-state >nul
adb wait-for-device
goto start

:sub
set filePath=%1
set fileName=%~n1
set channel=%fileName:~-26,10%
set toolPath=D:\MyNote\File
::混淆资源
java -jar %toolPath%\AndResGuard\andresguard-1.1.jar %filePath% -config %toolPath%\AndResGuard\config.xml -out %USERPROFILE%\Desktop\temp\%channel% -7zip "C:\Program Files\7-Zip\7z.exe" -zipalign %ANDROID_HOME%\build-tools\28.0.3\zipalign.exe
::360包加固
set unsigned=%USERPROFILE%\Desktop\temp\%channel%\%fileName%_unsigned.apk
call :jiagu %unsigned%
::重签名
java -jar %ANDROID_HOME%\build-tools\28.0.3\lib\apksigner.jar sign --ks  D:\Projects\CityForest\app\forest.jks --ks-key-alias forest --ks-pass pass:forest888 --key-pass pass:forest888 --out %USERPROFILE%\Desktop\output\%fileName%.apk %unsigned%
::瓦力渠道包
java -jar %toolPath%\walle-cli-all.jar batch -c BDP1000000,BDP1000002,BDP1000003,BDP1000004,BDP1000005,BDP1000006,BDP1000007,BDP1000008,BDP1000009,BDP1000010,BDP1000011,BDP1000012,BDP1000013,BDP1000014,BDP1000015,BDP1000016,BDP1000017,BDP1000018,BDP1000019,BDP1000020,BDP1000021 %USERPROFILE%\Desktop\output\%fileName%.apk
del %USERPROFILE%\Desktop\output\%fileName%.apk
::重命名
set now=%date:~0,4%%date:~5,2%%date:~8,2%-%time:~0,2%%time:~3,2%%time:~6,2%
echo %fileName%|findstr "__" >nul
if %errorlevel% equ 0 (
	for /f "tokens=1-9 delims=_." %%i IN ('dir %USERPROFILE%\Desktop\output /b') do ren %USERPROFILE%\Desktop\output\%%i_%%j.%%k.%%l__%%m_%%n_%%o_%%p.%%q %%i_%%j.%%k.%%l_%%p_%now: =0%_%%m.%%q
) else (
	for /f "tokens=1-9 delims=_." %%i IN ('dir %USERPROFILE%\Desktop\output /b') do ren %USERPROFILE%\Desktop\output\%%i_%%j.%%k.%%l_%%m_%%n_%%o_%%p.%%q %%i_%%j.%%k.%%l_%%p_%now: =0%_%%m.%%q
)
goto :eof

:jiagu
set _360Path=E:\Soft\jiagu
set un_jiagu=%1
%_360Path%\java\bin\java -jar %_360Path%\jiagu.jar -login emailbomber1@163.com y*1louYJX41
%_360Path%\java\bin\java -jar %_360Path%\jiagu.jar -config -crashlog -analyse -nocert
%_360Path%\java\bin\java -jar %_360Path%\jiagu.jar -importsign D:\Projects\CityForest\app\forest.jks forest888 forest forest888
%_360Path%\java\bin\java -jar %_360Path%\jiagu.jar -jiagu %un_jiagu% %~d1%~p1
del /Q %un_jiagu%
FOR /R %~d1%~p1 %%i IN (*_jiagu.apk) DO (
	rename %%i %~n1.apk
)
goto :eof

:start
md %USERPROFILE%\Desktop\output
FOR /R %USERPROFILE%\Desktop\input %%i IN (*.apk) DO (
	call :sub %%i
)

@echo -----------------mission completed-----------------
:showResult
set /p apkPath="Absolute Path(press q exit):"
if "%apkPath%"=="q" (
	goto end
)
java -jar %ANDROID_HOME%\build-tools\28.0.3\lib\apksigner.jar verify -v %apkPath%
java -jar %toolPath%\walle-cli-all.jar show %apkPath%
goto showResult

:end
```

#### 一个渠道包单独处理

```bat
@echo off
goto start

:sub
set filePath=%1
set fileName=%~n1
set channel=%fileName:~-26,10%
set toolPath=D:\GitHub\MyNote\File
::混淆资源
java -jar %toolPath%\AndResGuard\andresguard-1.1.jar %filePath% -config %toolPath%\AndResGuard\config.xml -out %USERPROFILE%\Desktop\temp\%channel% -7zip "C:\Program Files\7-Zip\7z.exe" -zipalign %ANDROID_HOME%\build-tools\28.0.3\zipalign.exe
::360包加固
set unsigned=%USERPROFILE%\Desktop\temp\%channel%\%fileName%_unsigned.apk
call :jiagu %unsigned%
::重签名
java -jar %ANDROID_HOME%\build-tools\28.0.3\lib\apksigner.jar sign --ks  D:\Project\Forest\app\forest.jks --ks-key-alias forest --ks-pass pass:forest888 --key-pass pass:forest888 --out %USERPROFILE%\Desktop\output\%fileName%.apk %unsigned%
::瓦力渠道包
java -jar %toolPath%\walle-cli-all.jar batch -c BDP1000000,BDP1000002,BDP1000003,BDP1000004,BDP1000005,BDP1000006,BDP1000007,BDP1000008,BDP1000009,BDP1000010,BDP1000011,BDP1000012,BDP1000013,BDP1000014,BDP1000015,BDP1000016,BDP1000017,BDP1000018,BDP1000019,BDP1000020,BDP1000021 %USERPROFILE%\Desktop\output\%fileName%.apk
del %USERPROFILE%\Desktop\output\%fileName%.apk
::重命名
set now=%date:~0,4%%date:~5,2%%date:~8,2%-%time:~0,2%%time:~3,2%%time:~6,2%
echo %fileName%|findstr "__" > nul
if %errorlevel% equ 0 (
	for /f "tokens=1-9 delims=_." %%i IN ('dir %USERPROFILE%\Desktop\output /b') do ren %USERPROFILE%\Desktop\output\%%i_%%j.%%k.%%l__%%m_%%n_%%o_%%p.%%q %%i_%%j.%%k.%%l_%%p_%now: =0%_%%m.%%q
) else (
	for /f "tokens=1-9 delims=_." %%i IN ('dir %USERPROFILE%\Desktop\output /b') do ren %USERPROFILE%\Desktop\output\%%i_%%j.%%k.%%l_%%m_%%n_%%o_%%p.%%q %%i_%%j.%%k.%%l_%%p_%now: =0%_%%m.%%q
)
goto :eof

:jiagu
set _360Path=E:\jiagu
set un_jiagu=%1
%_360Path%\java\bin\java -jar %_360Path%\jiagu.jar -login bidepan88 BIDEPAN888
%_360Path%\java\bin\java -jar %_360Path%\jiagu.jar -config -crashlog -analyse -nocert
%_360Path%\java\bin\java -jar %_360Path%\jiagu.jar -importsign D:\Project\Forest\app\forest.jks forest888 forest forest888
%_360Path%\java\bin\java -jar %_360Path%\jiagu.jar -jiagu %un_jiagu% %~d1%~p1
del /Q %un_jiagu%
FOR /R %~d1%~p1 %%i IN (*_jiagu.apk) DO (
	rename %%i %~n1.apk
)
goto :eof

:start
md %USERPROFILE%\Desktop\output
FOR /R %USERPROFILE%\Desktop\input %%i IN (*.apk) DO (
	call :sub %%i
)

@echo -----------------mission completed-----------------
:showResult
set /p apkPath="Absolute Path(press q exit):"
if "%apkPath%"=="q" (
	goto end
)
java -jar %ANDROID_HOME%\build-tools\28.0.3\lib\apksigner.jar verify -v %apkPath%
java -jar %toolPath%\walle-cli-all.jar show %apkPath%
goto showResult

:end
```

