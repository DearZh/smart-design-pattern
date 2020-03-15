package com.smart.sdp.proxy.statics;

/**
 * 使用代理的方式对ConnectionImpl的所有方法调用都增加日志的拦截操作
 *
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-15
 */
public class ConnectionImplProxy implements Connection {

    private ConnectionImpl connection;

    public ConnectionImplProxy(ConnectionImpl connection) {
        this.connection = connection;
    }


    @Override
    public Connection openConnection() {
        System.out.println("openConnection方法执行前进行日志拦截");

        Connection connection = this.connection.openConnection();

        System.out.println("openConnection方法执行后进行日志拦截");
        return connection;
    }

    @Override
    public void closeConnection() {
        System.out.println("closeConnection方法执行前进行日志拦截");
        this.connection.closeConnection();
        System.out.println("closeConnection方法执行后进行日志拦截");
    }

    @Override
    public boolean executeSql(String sql) {
        System.out.println("executeSql方法执行前进行日志拦截");

        Boolean flag = this.connection.executeSql(sql);

        System.out.println("executeSql方法执行后进行日志拦截");
        return flag;
    }
}
