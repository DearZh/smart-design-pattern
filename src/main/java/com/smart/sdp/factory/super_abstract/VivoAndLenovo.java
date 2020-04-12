package com.smart.sdp.factory.super_abstract;

import com.smart.sdp.factory.super_abstract.product.IMobile;
import com.smart.sdp.factory.super_abstract.product.MobileVIVO;
import com.smart.sdp.factory.super_abstract.product.ComputerLenovo;
import com.smart.sdp.factory.super_abstract.product.IComputer;

/**
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-28
 */
public class VivoAndLenovo implements Factory {
    @Override
    public IMobile instaceMobile() {
        return new MobileVIVO();
    }

    @Override
    public IComputer instaceComputer() {
        return new ComputerLenovo();
    }
}
