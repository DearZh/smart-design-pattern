package com.smart.sdp.factory.simple;

import com.smart.sdp.factory.simple.product.IMobile;
import com.smart.sdp.factory.simple.product.MobileOPPO;
import com.smart.sdp.factory.simple.product.MobileVIVO;

/**
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-28
 */
public class Factory {

    public static IMobile createProduce(String name) {
        if ("OPPO".equals(name)) {
            return new MobileOPPO();
        } else if ("VIVO".equals(name)) {
            return new MobileVIVO();
        }
        return null;
    }
}
