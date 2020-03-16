```bat
@echo off
set /p rpkPath="Please enter the rpk file path:"
adb push %% /data/local/tmp/rpk_file.rpk
::debugmode: MODE_NORMAL=0; MODE_DEBUG_RUN=1; MODE_DEBUG_CHROME=2; MODE_DEBUG_LOAD_CACHE=3;
adb shell am start -a android.intent.action.MAIN -c android.intent.category.LAUNCHER -f 0x4000000 -n com.huawei.fastapp.app.RpkRunnerActivity --es rpkpath file:///data/local/tmp/rpk_file.rpk --ei debugmode 2
```

