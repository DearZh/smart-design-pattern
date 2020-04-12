package com.smart.sdp.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-28
 */
public class Person implements Observer {

    private String name;


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("我是：" + name + "，小米终于又生产了" + arg + "部手机，我要开始准备抢啦！");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
