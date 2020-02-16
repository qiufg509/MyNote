#### 读取MD5 、 SHA1、 SHA256的三种方式

```
@echo off
set /p intput="Please enter the file(jks,keystore,apk,rsa) path to query:"
call :sub %intput%
goto end

:sub
if "%~x1" equ ".apk" (
	keytool -printcert -jarfile %1
) else if "%~x1" equ ".APK" (
	keytool -printcert -jarfile %1
) else if "%~x1" equ ".keystore" (
	keytool -list -v -keystore %1
) else if "%~x1" equ ".KEYSTORE" (
	keytool -list -v -keystore %1
) else if "%~x1" equ ".jks" (
	keytool -list -v -keystore %1
) else if "%~x1" equ ".JKS" (
	keytool -list -v -keystore %1
) else if "%~x1" equ ".rsa" (
	keytool -printcert -file %1
) else if "%~x1" equ ".RSA" (
	keytool -printcert -file %1
) else (
	echo "Current only supports jks,keystore,apk,rsa files!"
)
goto :eof

:end
```


