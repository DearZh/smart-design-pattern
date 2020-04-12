package com.smart.sdp.factory.simple_upgrade;

import com.smart.sdp.factory.simple_upgrade.product.IMobile;
import com.smart.sdp.factory.simple_upgrade.product.MobileVIVO;

/**
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-28
 */
public class VIVOFactory implements Factory {
    @Override
    public IMobile instaceMobile() {
        return new MobileVIVO();
    }
}
