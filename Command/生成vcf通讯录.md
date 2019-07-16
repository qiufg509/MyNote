源文件Excel或者Word时，先将数据copy到original.txt中

```bat
@echo off
echo 确保original.txt和card.vcf为ANSI格式
for /f "tokens=1-7 delims= " %%i in ( %userprofile%\Desktop\original.txt ) do (
	call :sub %%i %%j %%k %%l %%m %%n %%o
)
set /p="转换编码为UTF-8后回车导入手机"
adb push %userprofile%\Desktop\card.vcf /sdcard
goto end

:sub
set book=%USERPROFILE%\Desktop\card.vcf
echo BEGIN:VCARD >> %book%
echo EMAIL;type=INTERNET;type=pref:%1>> %book%
echo TEL;type=CELL;type=VOICE;type=pref:%6>> %book%
set name=%3
echo N:%name:~0,1%;%name:~1%;;;>> %book%
echo FN:%name%>> %book%
echo VERSION:3.0>> %book%
echo END:VCARD>> %book%
goto :eof

:end
pause
```

