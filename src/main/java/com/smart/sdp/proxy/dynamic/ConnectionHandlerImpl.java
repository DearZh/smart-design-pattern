package com.smart.sdp.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-15
 */
public class ConnectionHandlerImpl implements InvocationHandler {

    /**
     * 需要被代理的具体对象实例
     */
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * @description:
     * @param: [proxy 代理类的实例, method 被调用的方法对象, args 被调用的方法参数]
     * @return: java.lang.Object
     * @author: Arnold.zhao
     * @date: 2020/3/15
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("-----------被代理对象，方法执行前操作输出---------------------");

        if (args != null && args.length > 0) {
            for (Object ob : args) {
                System.out.println("方法参数是：" + ob);
            }
        }

        //方法执行
        Object object = method.invoke(target, args);

        System.out.println("------------------被代理对象，方法执行后操作-------------");
        return object;
    }


    /**
     * @description: 获取被代理后的对象实例
     * @return: java.lang.Object
     * @author: Arnold.zhao
     * @date: 2020/3/15
     */
    public Object getTargetProxy() {
        /**
         * 1、通过使用Proxy.newProxyInstance()来实现代理类的生成；
         * 2、newProxyInstance()方法的传参分别是：（1、被代理对象的classLoader，2、当前被代理对象的所有接口集合，3、InvocationHandler接口的具体实现类对象 new ConnectionHandlerImpl，因为要执行当前接口实现类的invoke()方法；（此处this特质对象自身的引用，正是因为此处是new ConnectionHandlerImpl()对象本身，所以target类属性所赋的值才能是线程安全，且在invoke()方法中可以被调用的；所以target属性肯定不能是静态的啦，当前ConnectionHandlerImpl的使用就是非单例多态的方式来使用的，每次的使用都需要重新new对象的方式来使用（））
         */
        Object objectProxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        //最终所构建出的动态代理类object，实际就是继承了Proxy类并且实现了target.getClass().getInterfaces()接口集合的一个代理类，所以在获取到当前代理类后，
        //才可以通过强转为任意一个接口或者Proxy的方式进行使用；

        //

        return objectProxy;
    }

}
