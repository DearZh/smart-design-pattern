package com.smart.sdp.proxy.statics;

/**
 *
 *
 * @author arnold.zhao
 * @date 2020/3/15 16:45
 */
public interface Connection {

    Connection openConnection();

    void closeConnection();

    boolean executeSql(String sql);
}
