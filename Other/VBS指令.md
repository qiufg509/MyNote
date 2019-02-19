# VBS指令

1. **SendKeys** [String]：模拟按按键

   ```vbscript
   '切换输入法（模拟同时按下：Shift 空格）
   Dim ws
   Set ws = CreateObject("WScript.Shell")
   WScript.Sleep 4000
   ws.SendKeys "^ "
   ```

2. **do ... loop**：循环

   ```vbscript
   Dim Count:Count = 5 '定义一个变量
   Do Until Count = 0 '直到Count变量为0时，否则一直循环
       MsgBox Count
       Count = Count -1
   Loop
   ```

   ```vbscript
   Dim Count:Count = 5 '定义一个变量
   Do While Count <> 0 '当Count变量为0时，停止循环
       MsgBox Count
       Count = Count -1
   Loop
   MsgBox "循环结束"
   ```

3. **Run**：运行程序

   ```vbscript
   '打开记事本
   Set WshShell=WScript.CreateObject("WScript.Shell") 
   WshShell.Run "notepad"
   ```

4. **AppActivate**：激活窗口

   ```vbscript
   set s = WScript.CreateObject("WScript.Shell")
   app=s.Run ("D:\Progra~1\Tencent\QQ\QQ.exe") '你QQ的路径！'注意Program Files要写成Progra~1
   WScript.Sleep 1000
   s.AppActivate app
   ```

5. **Sleep**：等待指定时间（不用创建对象）

   ```vbscript
   '休眠4秒
   WScript.Sleep 4000
   ```

6. **vbhide**：隐藏当前窗口

   ```vbscript
   '隐藏执行C:\test.bat
   Set ws = CreateObject("Wscript.Shell") 
   ws.run "cmd /c C:\test.bat",vbhide
   ```





   #### 自动登录邮箱

   ```vbscript
   set s = WScript.CreateObject("WScript.Shell") '创建WScript.Shell对象
   app=s.Run ("chrome") '打开chrome浏览器
   WScript.Sleep 1000
   s.AppActivate app
   s.SendKeys "https://mail.163.com/"
   s.SendKeys "{ENTER}"
   s.SendKeys "{ENTER}" '中文输入法，要多一次回车确认
   WScript.Sleep 1000
   s.SendKeys "account"
   s.SendKeys "{ENTER}"
   WScript.Sleep 1000
   s.SendKeys "{TAB}"
   s.SendKeys "password"
   s.SendKeys "{ENTER}"
   ```




#### vbs基本和特殊按键

|     按键     |        对应发送的键值         |                             备注                             |
| :----------: | :---------------------------: | :----------------------------------------------------------: |
|    空格键    |              " "              |                                                              |
|    退格键    | {BACKSPACE} 或 {BS} 或 {BKSP} |                                                              |
|    BREAK     |            {BREAK}            |                                                              |
|    Delete    |   {Delete}     或     {DEL}   |                                                              |
|    向下键    |            {DOWN}             |                                                              |
|    向上键    |             {UP}              |                                                              |
|    向左键    |            {LEFT}             |                                                              |
|    向右键    |            {RIGHT}            |                                                              |
|     END      |             {END}             |                                                              |
|    ENTER     |     {ENTER}     或     ~      |                                                              |
|     ESC      |             {ESC}             |                                                              |
|     TAB      |             {TAB}             |                                                              |
|  CAPS LOCK   |          {CAPSLOCK}           |                                                              |
|     HELP     |            {HELP}             |                                                              |
|     HOME     |            {HOME}             |                                                              |
|    Insert    |   {Insert}     或     {INS}   |                                                              |
|   NUM LOCK   |           {NUMLOCK}           |                                                              |
|  PAGE DOWN   |            {PGDN}             |                                                              |
|   PAGE UP    |            {PGUP}             |                                                              |
| PRINT SCREEN |            {PRTSC}            |                                                              |
| SCROLL LOCK  |         {SCROLLLOCK}          |                                                              |
|      F1      |             {F1}              |                                                              |
|      F2      |             {F2}              |                                                              |
|      F3      |             {F3}              |                                                              |
|      F4      |             {F4}              |                                                              |
|      F5      |             {F5}              |                                                              |
|      F6      |             {F6}              |                                                              |
|      F7      |             {F7}              |                                                              |
|      F8      |             {F8}              |                                                              |
|      F9      |             {F9}              |                                                              |
|     F10      |             {F10}             |                                                              |
|     F11      |             {F11}             |                                                              |
|     F12      |             {F12}             |                                                              |
|    SHIFT     |               +               |                                                              |
|     CTRL     |               ^               |                                                              |
|     ALT      |               %               |                                                              |
|      +       |              {+}              |                                                              |
|      ^       |              {^}              |                                                              |
|      %       |             '{%}'             | 使用时去掉单引号<br/>(大括号百分号没有<br/>成对使用导致github<br/>编译失败) |

