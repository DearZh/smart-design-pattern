package com.smart.sdp.adapter;

import com.smart.sdp.factory.simple.product.MobileOPPO;

import java.util.Observable;
import java.util.Observer;

/**
 * 类适配器
 *
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-04-08
 */
public class ObserverMobileOPPO extends MobileOPPO implements Observer {

    /**
     * @description: 实现观察者接口
     * @author: Arnold.zhao
     * @date: 2020/4/8
     */
    @Override
    public void update(Observable o, Object arg) {
        //一旦当前观察者被通知，则调用父类的method()方法，进行OPPO手机的生产
        super.method();
    }
}
