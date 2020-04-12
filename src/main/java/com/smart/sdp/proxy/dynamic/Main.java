package com.smart.sdp.proxy.dynamic;

import com.smart.sdp.proxy.statics.Connection;
import com.smart.sdp.proxy.statics.ConnectionImpl;

/**
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-15
 */
public class Main {

    public static void main(String[] args) {
        ConnectionHandlerImpl connectionHandler = new ConnectionHandlerImpl();
        //set 被代理类的具体实例（当前被代理的类必须有实现接口）
        connectionHandler.setTarget(new ConnectionImpl());

        //得到被代理的对象实例，此时强制转换只能转换为接口（）
        Connection connectionProxy = (Connection) connectionHandler.getTargetProxy();

        //调用当前被代理类的方法
        connectionProxy.openConnection();
        connectionProxy.closeConnection();
        System.out.println(connectionProxy.executeSql("select * from "));
    }
}
