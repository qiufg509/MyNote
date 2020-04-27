源文件内容格式为1008344@qq.com----yk890102----袁康----123456789630145879----kangbaowu----18556666666----1008344@qq.com

```bat
@echo off
::set window charset utf-8
CHCP 65001 >nul
set /p original="Please enter the file name:"
set book=%USERPROFILE%\Desktop\card.vcf
if exist %book% del %book%
for /f "tokens=1-7 delims=-" %%i in ( %original% ) do (
	call :sub %%i %%j %%k %%l %%m %%n %%o
)
goto end

:sub
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
```

