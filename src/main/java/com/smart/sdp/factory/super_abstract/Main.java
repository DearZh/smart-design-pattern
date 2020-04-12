package com.smart.sdp.factory.super_abstract;

import com.smart.sdp.factory.super_abstract.product.IComputer;
import com.smart.sdp.factory.super_abstract.product.IMobile;

/**
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-28
 */
public class Main {

    public static void main(String[] args) {
        //定义生产Oppo手机和Dell电脑的生产线
        Factory factory = new OppoAndDellFactory();
        IComputer iComputer = factory.instaceComputer();
        IMobile iMobile = factory.instaceMobile();

        iComputer.method();
        iMobile.method();

        //此时更换工厂方法，切换为生产Vivo手机和Lenovo的生产线
        factory = new VivoAndLenovo();
        iComputer = factory.instaceComputer();
        iMobile = factory.instaceMobile();
        iComputer.method();
        iMobile.method();
        /*
        执行结果：
            ***生产Dell电脑****
            ---------负责生产OPPO手机------------
            ***生产Lenovo电脑****
            ---------负责生产VIVO手机------------
         */
    }
}
