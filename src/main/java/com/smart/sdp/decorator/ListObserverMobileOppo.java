package com.smart.sdp.decorator;

import com.smart.sdp.adapter.ObserverMobileOPPO;

import java.util.ArrayList;
import java.util.List;

public class ListObserverMobileOppo extends MobileOppoDecorator {

    private List list = new ArrayList();


    public ListObserverMobileOppo(ObserverMobileOPPO observerMobileOPPO) {
        super(observerMobileOPPO);
    }

    public void enhance() {
        System.out.println("扩展新的接口");
    }

    public void method() {
        //执行原有的要扩展的方法
        super.oppo.method();
    }
}
