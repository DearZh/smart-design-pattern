package com.smart.sdp.adapter;

import java.util.ArrayList;
import java.util.Observable;

/**
 * 对象适配器
 *
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-04-08
 */
public class ListObserverMobileOPPO extends ObserverMobileOPPO {

    private ArrayList arrayList = new ArrayList();


    /**
     * @description: 重写父类的update方法，每次被通知后则将当前对象实例新增到arrayList集合中
     * @author: Arnold.zhao
     * @date: 2020/4/8
     */
    @Override
    public void update(Observable o, Object arg) {
        arrayList.add(this);
        super.update(o, arg);
    }
}
