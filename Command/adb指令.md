#### mokey测试

```batch
monkey -p com.hampoo.home.setting --ignore-crashes --ignore-timeouts --kill-process-after-error --ignore-security-exceptions --throttle 200 -v -v -v -s 5 100000000 1>>/sdcard/log.log 2>>/sdcard/log_err.log
```

#### 导出已安装APK

```
adb shell pm list packages
adb shell pm path com.huawei.camera
adb pull /system/priv-app/HwCamera2/HwCamera2.apk  C:/Users/fly/Desktop
```

