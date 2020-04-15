package com.smart.sdp.decorator;

import com.smart.sdp.adapter.ObserverMobileOPPO;

import java.util.HashMap;
import java.util.Map;

public class MapObserverMobileOppo extends MobileOppoDecorator {

    private Map<String, Object> map = new HashMap<String, Object>();

    public MapObserverMobileOppo(ObserverMobileOPPO observerMobileOPPO) {
        super(observerMobileOPPO);
    }
}
