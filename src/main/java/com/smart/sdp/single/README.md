# 单例模式

一共涉及到三个功能：

1、普通的单例类的设计方式

2、线程安全的单例类的设计方式

3、通过使用并发执行的方式来验证普通的单例类在并发的情况下所出现的问题

## 并发Test时共涉及到的功能点

1、自定义封装一个简单的Utils线程池，SmartThreadFactory，SmartExecutorService

2、CountDownLatch（共定义了三个栏栅，分别用于所有线程初始化执行时拦截，开启并发执行，以及执行后）

3、AtomicInteger(用来记录线程工厂每创建一次线程所对应的线程数量编号)

4、Synchronize（用来锁当前实例对象创建时的if判断代码块）

5、Collections.synchronizedSet() 用来获取一个线程安全的Set集合