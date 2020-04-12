package com.smart.sdp.proxy.cglib;

import com.smart.sdp.proxy.statics.ConnectionImpl;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-21
 */
public class Main {


    public static void main(String[] args) {
        //使用Enhancer来创建代理类
        Enhancer enhancer = new Enhancer();

        //设置所生成的代理类所需要继承的类（及需要被代理的类对象）
        enhancer.setSuperclass(ConnectionImpl.class);
        //设置方法的回调
        enhancer.setCallback(new ConnectionHeaderCglib());


        ConnectionImpl connection = (ConnectionImpl) enhancer.create();
        connection.openConnection();
        connection.closeConnection();

    }

}
