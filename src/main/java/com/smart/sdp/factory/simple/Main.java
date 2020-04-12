package com.smart.sdp.factory.simple;

import com.smart.sdp.factory.simple.product.IMobile;

/**
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-28
 */
public class Main {

    public static void main(String[] args) {

        //我需要获取一个生产VIVO手机的生产线
        IMobile iMobile = Factory.createProduce("VIVO");
        iMobile.method();
        //需要获取一个生产OPPO的生产线，则直接从工厂中获取即可
        iMobile = Factory.createProduce("OPPO");
        iMobile.method();

        /*
        输出结果：
        ---------负责生产VIVO手机------------
        ---------负责生产OPPO手机------------
         */
    }
}
