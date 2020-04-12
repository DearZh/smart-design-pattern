package com.smart.sdp.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 采用Cglib来动态生成ConnectionImpl的代理
 *
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-21
 */
public class ConnectionHeaderCglib implements MethodInterceptor {


    /**
     * @description:
     * @param: [o cglib生成的代理对象, method 被代理对象的方法, objects 方法的动态入参, methodProxy 代理方法]
     * @return: java.lang.Object
     * @author: Arnold.zhao
     * @date: 2020/3/21
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("--------CgLib代理开始执行-----------");
        methodProxy.invokeSuper(o, objects);
        System.out.println("--------CgLib代理结束执行-----------");
        return null;
    }
}
