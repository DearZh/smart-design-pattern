package com.smart.sdp.factory.super_abstract.product;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-28
 */
public class ComputerLenovo implements IComputer {
    @Override
    public void method() {
        System.out.println("***生产Lenovo电脑****");
    }
}
