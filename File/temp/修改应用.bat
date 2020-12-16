@echo off
set /p apkPath="Please enter the APK file path:"
set apktool=%MY_NOTE%\File\apktool_2.4.1.jar
call :Decode %apkPath%
call :Modify %unzipDir%
echo Modify the file and press Enter to continue: & pause>nul
call :Build
call :Signapk
goto end

:Decode
set unzipDir=%~dpn1_temp
set apkname=%~nx1
java -jar %apktool% d -f -r %1 -o %unzipDir%
goto :eof

:Modify
"C:\Program Files (x86)\Notepad++\notepad++.exe" %unzipDir%\AndroidManifest.xml
goto :eof

:Build
java -jar %apktool% b %unzipDir%
goto :eof

:Signapk
java -jar %ANDROID_HOME%\build-tools\30.0.2\lib\apksigner.jar sign --ks %MY_NOTE%\File\qiufg509.jks --ks-ket-alias qiufg509 --ks-pass pass:qiufg509 --key-pass pass:qiufg509 --out %unzipDir%\dist\%apkname%
got :eof

:end