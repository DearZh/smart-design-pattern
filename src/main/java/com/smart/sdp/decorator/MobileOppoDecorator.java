package com.smart.sdp.decorator;

import com.smart.sdp.adapter.ObserverMobileOPPO;

public class MobileOppoDecorator {

    public ObserverMobileOPPO oppo;

    public MobileOppoDecorator(ObserverMobileOPPO observerMobileOPPO) {
        this.oppo = observerMobileOPPO;
    }
}
