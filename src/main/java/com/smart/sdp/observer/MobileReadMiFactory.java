package com.smart.sdp.observer;

import java.util.Observable;
import java.util.Observer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 被观察者：手机工厂
 *
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-28
 */
public class MobileReadMiFactory extends Observable {

    public void productionPhone() {
        System.out.println("小米工厂已经生产手机完毕，进行观察者通知");
        //更改当前为通知状态
        setChanged();
        //通知所有观察者们，当前小米工厂新生产的手机数量
        notifyObservers("100");
    }
}
