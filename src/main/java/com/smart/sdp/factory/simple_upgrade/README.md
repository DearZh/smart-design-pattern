# 简单工厂升级版
定义：工厂方法(Factory Method)模式的意义是定义一个创建产品对象的工厂接口，将实际创建工作推迟到子类当中。核心工厂类不再负责产品的创建，这样核心类成为一个抽象工厂角色，仅负责具体工厂子类必须实现的接口，这样进一步抽象化的好处是使得工厂方法模式可以使系统在不修改具体工厂角色的情况下引进新的产品。


# 具体实现
可以看到，相比于“simple”包下的简单工厂代码，我们此处做的最大的优化就是：
抽象了我们的Factory工厂类，使其变更为了一个接口；我们只需要在接口中定义好，我们的
接口方法就是生产IMobile手机后，至于你是要生产OPPO手机还是要生产VIVO手机，只需要实现该方法接口，
然后自己写一套生产OPPO手机的Factory类即可;

这样做的好处就是，假设我们此处需要再新增一个生产小米手机的生产线，那么我们只需要动态新增ReadMiFactory，
然后实现Factory的接口方法即可，而不需要再像简单工厂那样需要动态修改Factory工厂方法来通过判断的方式来增加小米的生产线了；

所以想比于我们第一次的简单工厂的方式，现在的做法也使得我们在动态扩展上更加容易，且也更好的符合了设计模式的“开闭原则”；

# 总结 
相比于简单工厂，当前的升级版工厂是抽象了Factory工厂类，使其升级为了接口，
而具体的产品则实现该Factory接口后，单独实现产品工厂；