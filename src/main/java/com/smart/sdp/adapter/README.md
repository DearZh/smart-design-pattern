# 适配器模式
适配器模式从实现方式上分为两种，类适配器和对象适配器，这两种的区别在于实现方式上的不同，一种采用继承，一种采用组合的方式

重点：适配器模式实现上分别分为：继承和组合方式；

# 实现方式
## 在不改变原有类的代码的情况下，使其具备其它接口的特性（采用继承方式）

比如：在工厂模式中产品MobileOPPO已经是定义了很多OPPO自身手机特性的一个类，
那么此时如果需要实现Observer接口使其类加入到观察者模式中，应该如何操作？有几种实现方式？

1、动态修改MobileOPPO的类代码，使其再实现一个implements Observer 接口；

2、新建一个ObserverMobileOPPO类，并继承原有的MobileOPPO类，使其具备
MobileOPPO所有的所有类功能；然后再实现implements Observer 接口；

上述1,2那种选择更好，当然是第二种；原因是因为MobileOPPO已经是一个高内聚的一个产品类
，如果只是要扩展一个接口就修改了这样一个类的代码，也是不符合“开闭原则”的；
另外一种情况是：如果当前MobileOPPO类已经被整合到一个项目的Jar包中了，那么此时再想动态修改
该类几乎是不可能的事情，所以通过使用第二种方式来增加新的功能是最佳的选择；而这实际上就是大名鼎鼎的
类适配器模式；

## 避免单继承的缺陷，采用组合方式方式使其当前类具备其他功能
还是以上述的MobileOPPO类为例，此时由于我们需要在不修改MobileOPPO类的前提下动态扩展观察者接口，所以我们新写了一个
ObserverMobileOPPO类，来继承了 MobileOPPO且实现了 Observer接口，那么问题来了？

如果我们此时需要将ObserverMobileOPPO类再继承一个新的类怎么办？
比如此时需要实现观察者类一旦被通知生产以后，则自动将当前所生产的OPPO产品添加到一个ArrayList集合中？如何实现？有几种实现方式？

1、将当前的ObserverMobileOPPO类继承一下 ArrayList集合，使其具备ArrayList集合的功能，这样便可以直接使用super.add()方法来进行数据的存储

2、将当前ArrayList作为ObserverMobileOPPO类的一个属性而存在，ArrayList arrayList = new ArrayList();
此时则可以直接通过arrayList.add()的方式来进行方法的调用；

没毛病吧，要么继承ArrayList集合，要么使其作为类属性，new ArrayList()集合后，然后进行方法的掉用；

上述两个方法都可以实现ArrayList的功能然后进行方法的调用，但是那种方式更好呢？显然是第二种，因为第一种继承的方式很容易被Java自身的单继承特性所限制；
比如上述的ObserverMobileOPPO类此时已经继承了MobileOPPO类，显然不能再进行类的继承，所以采用第二种才是最好的结果；而这实际上就是大名鼎鼎的对象适配器模式；

为了不破坏原有的ObserverMobileOPPO类结构，所以此处实现一个新的ListObserverMobileOPPO类，来实现ArrayList记录的功能；

# 总结
如果需要将当前类重新适配一个接口的功能的话，则是类适配器；（采用继承的方式，然后再实现新的接口）

如果需要将当前类重新适配一个对象的功能的话，则是对象适配器；（采用组合的方式，及类属性注入的方式）

以上：如果当前ListObserverMobileOPPO类需要再适配一个新的接口的话，怎么办？此时只需要新增一个新的类A继承ListObserverMobileOPPO并实现一个新的接口即可；
那么此时这个新的类A如果需要再实现一个新的对象功能的话，怎么办？我们可以再写一个新的类B继承类A，然后实现新对象的属性注入即可；
以此可以实现无限的反复适配；