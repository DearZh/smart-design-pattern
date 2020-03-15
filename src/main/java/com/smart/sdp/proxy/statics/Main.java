package com.smart.sdp.proxy.statics;

/**
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-15
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 直接使用ConnectionImpl方法
         */
        Connection connection = new ConnectionImpl();
        connection.openConnection();
        connection.closeConnection();

        //使用ConnectionImpl代理进行方法调用
        Connection connectionProxy = new ConnectionImplProxy(new ConnectionImpl());
        connectionProxy.openConnection();
        connectionProxy.closeConnection();
    }
}
