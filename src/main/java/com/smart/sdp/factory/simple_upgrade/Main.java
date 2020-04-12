package com.smart.sdp.factory.simple_upgrade;

import com.smart.sdp.factory.simple_upgrade.product.IMobile;

/**
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-28
 */
public class Main {

    public static void main(String[] args) {
        //获取生产OPPO的生产线
        Factory factory = new OPPOFactory();
        IMobile iMobile = factory.instaceMobile();
        iMobile.method();
        //获取生产VIVO的生产线
        factory = new VIVOFactory();
        iMobile = factory.instaceMobile();
        iMobile.method();

        /*
        执行结果：

            ---------负责生产OPPO手机------------
            ---------负责生产VIVO手机------------
         */
    }
}
