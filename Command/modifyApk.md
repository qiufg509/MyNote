```bat
@echo off
set /p apkPath="Please enter the APK file path:"
set apkTool=D:\MyNote\File\apktool_2.4.1.jar
call :Decode %apkPath%
call :Modify %unzipDir%
echo Modify the file and press Enter to continue: & pause>nul
call :Build
call :SignApk
goto end

:Decode
set unzipDir=%~dpn1_tmp
set apkName=%~nx1
rem decode AndroidManifest1.xml
::java -jar %apkTool% d -f -r %1 -o %unzipDir%
java -jar %apkTool% d -f %1 -o %unzipDir%
goto :eof

:Modify
"C:\Program Files (x86)\Notepad++\notepad++.exe" %unzipDir%\AndroidManifest1.xml
goto :eof

:Build
java -jar %apkTool% b %unzipDir%
goto :eof

:SignApk
set signer=%ANDROID_HOME%\build-tools\28.0.3\lib\apksigner.jar
set jks=D:\MyNote\File\qiufg509.jks
java -jar %signer% sign --ks %jks% --ks-key-alias key0 --ks-pass pass:qiufg509 --key-pass pass:qiufg888 --out %USERPROFILE%\Desktop\%apkName% %unzipDir%\dist\%apkName%
goto :eof

:end
```