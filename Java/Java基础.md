# 一、谈谈你对Java平台的理解？



# 二、Exception和Error有什么区别？

Exception和Error都继承自Throwable，只有继承自Throwable类的异常才能throw和try...catch。

Exception是正常情况下可以预测的异常，需要做



# 三、谈谈final、finally、finalize有什么区别？



# 四、强引用、软引用、弱引用、虚引用有什么区别？



# 五、String、StringBuffer、StringBuild有什么区别？



# 六、动态代理是基于什么原理？



# 七、int和Interge有什么区别？



# 八、对比Vector、ArrayList、LinkedList有和区别？



# 九、对比hashtable、HashMap、TreeMap有什么不同？



# 十、如何保证集合是线程安全的？ConcurrentHashMap如何实现高效的线程安全？

Java提供了不同层面的线程安全支持。在传统集合框架内部，除了Hashtable等同步容器，还提供了所谓的同步包装器，我们可以调用Collections工具类提供的包装方法，来获取一个同步的包装容器，但是它们都是利用非常粗粒度的同步方式，在高并发情况下，性能比较低下。

另外，更加普表达选择是利用并发包提供的线程安全容器类，它提供了：

各种并发容器，比如ConcurrentHashMap、CopyOnWriteArrayList。

各种线程安全队列，如ArrayBlockingQueue、SynchronousQueue。

各种有序容器的线程安全版本等。

各种保证线程安全的方式，包括有从简单的synchronize方式，到基于更加精细化的，比如基于分离锁实现的ConcurrentHashMap等并发实现等。具体选择要看开发的场景需要，总体来说，并发包内提供的容器通用场景，远优于早期的简单同步实现。



# 十一、Java提供了哪些IO方式？NIO如何实现多路复用？







