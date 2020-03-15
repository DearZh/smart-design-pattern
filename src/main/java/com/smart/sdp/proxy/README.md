# 代理模式
Java中实现对象代理的4种方式
## [静态代理](statics)
使用静态代理的方式实现Connection的接口方法在被执行前后，进行日志的记录操作；
类似于AOP的环绕通知；
## [JDK动态代理](dynamic)
主要实现java.lang.reflect.InvocationHandler接口，以及通过java.lang.reflect.Proxy 来生成对应的被代理对象的具体代理类；

## [CGLIB动态代理](cglib)

## [SpringAOP代理](aop)
此处使用AOP的功能来实现一个简单的业务模块：当用户访问一个Controller方法时,
自动的将当前用户的基本信息,IP地址,当前所访问的方法名称,方法作用存储到日志表中，
以此实现一个用户访问轨迹的记录功能；

SpringAOP实际是对CGLIB和JDK动态代理的一种封装，由于我们经常使用Spring框架作为基础组件
，所以在使用动态代理的时候更多的会采用AOP的方式进行；
