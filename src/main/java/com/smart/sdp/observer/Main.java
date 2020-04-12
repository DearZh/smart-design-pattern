package com.smart.sdp.observer;

/**
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-28
 */
public class Main {


    public static void main(String[] args) {

        Person person = new Person();
        person.setName("米粉1号");
        Person person2 = new Person();
        person2.setName("米粉2号");

        MobileReadMiFactory mobileReadMiFactory = new MobileReadMiFactory();
        //将观察者们加入到集合中，便于后续通知
        mobileReadMiFactory.addObserver(person);
        mobileReadMiFactory.addObserver(person2);

        //开始生产手机，并进行观察者用户通知
        mobileReadMiFactory.productionPhone();

        /*
        执行结果：
        小米工厂已经生产手机完毕，进行观察者通知
        我是：米粉2号，哇，小米终于又生产了100部手机，我要开始准备抢啦！
        我是：米粉1号，哇，小米终于又生产了100部手机，我要开始准备抢啦！
         */
    }
}
