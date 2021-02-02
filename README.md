# smart-design-pattern
:collision:   :imp: 吼吼！10分钟内快速回顾所有设计模式及应用场景 

Old Coding! 深知并发编程，熟悉OOP思想，但却因为种种原因！
没有在学习生涯初期就看设计模式的同学！尤其适合看下本项目！
让你在极短的时间内，增加自己的编程内功，从此成为抽象派coding达人，~~走向人生巅峰~~！


# 设计模式

## [单例模式](src/main/java/com/smart/sdp/single)
**1、如何实现一个单例对象；2、如何实现一个并发安全的单例对象（Double Check Lock）**
## [工厂模式](src/main/java/com/smart/sdp/factory)
1、简单工厂；2、简单工厂升级版；3、抽象工厂
## [代理模式](src/main/java/com/smart/sdp/proxy)
1、通过Java代码实现静态代理

2、JDK动态代理的实现

3、CGLIB动态代理的实现

4、基于SpringAop拦截所有的Controller层，实现统一的接口访问日志功能；

## [观察者模式](src/main/java/com/smart/sdp/observer)
继承JDK原生提供的Observable类实现被观察者，以及实现Observer观察者接口，从而实现观察者模式的联动；
## [策略模式](src/main/java/com/smart/sdp/strategy)
将一个接口作为对象参数进行传参，通过接口的多态性质，从而实现各种不同实现类的效果调用；

## [适配器模式](src/main/java/com/smart/sdp/adapter)
在不改变原有代码的情况下使其具备其它代码的特性（采用继承和组合的方式）

## [模板模式](src/main/java/com/smart/sdp/template)
**也是一个很舒服的设计模式之一，可以让你更加加深对父类（抽象类）的使用和理解；**

**此处重点说明下模板模式的原理以及JDK双亲委派机制对模板模式的运用；**
## [装饰器模式](src/main/java/com/smart/sdp/decorator)
 装饰器模式可以在不改变目标类以及不使用继承的情况下动态的扩展目标类，其使用方式与适配器模式相似度高达88%，故装饰器模式与适配器模式也统称为包装模式（Wrapper）
 
 注意：只是有99%相似，但还存在细微不同

------

更新ing...
