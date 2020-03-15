package com.smart.sdp.proxy.statics;

/**
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-15
 */
public class ConnectionImpl implements Connection {

    @Override
    public Connection openConnection() {
        //TODO
        System.out.println("链接已打开");

        return new ConnectionImpl();
    }

    @Override
    public void closeConnection() {
        //TODO
        System.out.println("链接已关闭");
    }

    @Override
    public boolean executeSql(String sql) {
        //TODO
        System.out.println("executeSql已执行");
        return true;
    }
}
