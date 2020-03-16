```bat
@echo off
FOR /F "tokens=5 delims= " %%i IN ('netstat -aon^|findstr "5037"') DO tasklist | findstr "%%i"
```

