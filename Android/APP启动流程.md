### 应用的主要启动流程

关于 App 启动流程的文章很多，文章底部有一些启动流程相关的参考文章，这里只列出大致流程如下：

1. 通过 Launcher 启动应用时，点击应用图标后，Launcher 调用 `startActivity` 启动应用。
2. Launcher Activity 最终调用 `Instrumentation` 的 `execStartActivity` 来启动应用。
3.  `Instrumentation` 调用 `ActivityManagerProxy` (`ActivityManagerService`  在应用进程的一个代理对象) 对象的 `startActivity` 方法启动 `Activity`。
4. 到目前为止所有过程都在 Launcher 进程里面执行，接下来 `ActivityManagerProxy` 对象跨进程调用 `ActivityManagerService` (运行在 `system_server` 进程)的 `startActivity` 方法启动应用。
5.  `ActivityManagerService` 的 `startActivity` 方法经过一系列调用，最后调用  `zygoteSendArgsAndGetResult` 通过 `socket` 发送给 `zygote` 进程，`zygote` 进程会孵化出新的应用进程。
6.  `zygote` 进程孵化出新的应用进程后，会执行 `ActivityThread` 类的 `main` 方法。在该方法里会先准备好 `Looper` 和消息队列，然后调用 `attach` 方法将应用进程绑定到 `ActivityManagerService`，然后进入 `loop` 循环，不断地读取消息队列里的消息，并分发消息。
7.  `ActivityManagerService` 保存应用进程的一个代理对象，然后 `ActivityManagerService` 通过代理对象通知应用进程创建入口 `Activity` 的实例，并执行它的生命周期函数。

**总结过程就是：**用户在 `Launcher` 程序里点击应用图标时，会通知 `ActivityManagerService` 启动应用的入口 `Activity`， `ActivityManagerService` 发现这个应用还未启动，则会通知 `Zygote` 进程孵化出应用进程，然后在这个应用进程里执行 `ActivityThread` 的 `main` 方法。应用进程接下来通知 `ActivityManagerService` 应用进程已启动，`ActivityManagerService` 保存应用进程的一个代理对象，这样 `ActivityManagerService` 可以通过这个代理对象控制应用进程，然后 `ActivityManagerService` 通知应用进程创建入口 `Activity` 的实例，并执行它的生命周期函数。



### 生命周期函数执行流程

上面的启动流程是 Android 提供的机制，作为开发者我们需要清楚或者至少了解其中的过程和原理，但我们并不能在这过程中做什么文章，我们能做的恰恰是从上述过程中最后一步开始，即 `ActivityManagerService` 通过代理对象通知应用进程创建入口 `Activity` 的实例，并执行它的生命周期函数开始，我们的启动时间统计以及启动速度优化也是从这里开始。下面是 Main Activity 的启动流程：

```
-> Application 构造函数
-> Application.attachBaseContext()
-> Application.onCreate()
-> Activity 构造函数
-> Activity.setTheme()
-> Activity.onCreate()
-> Activity.onStart
-> Activity.onResume
-> Activity.onAttachedToWindow
-> Activity.onWindowFocusChanged
```

[Android 开发之 App 启动时间统计]: https://www.jianshu.com/p/c967653a9468

