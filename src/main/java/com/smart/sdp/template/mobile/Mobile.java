package com.smart.sdp.template.mobile;

/**
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-04-12
 */
public abstract class Mobile {


    /**
     * @description: 手机的具体生产方式及生产过程，则由父类中直接定义完成，不再具体子类中实现
     * @author: Arnold.zhao
     * @date: 2020/4/12
     */
    public final void production() {
        String color = "先设计手机颜色为：" + mobileColor();

        String name = "开始激光定制手机名称：" + mobileName();

        String mobilePerformance = "开始安装核心处理器：" + mobilePerformance();

        System.out.println(color + name + mobilePerformance + ";手机最大的特色是：" + characteristic());
    }

    //定义手机品牌名称
    public abstract String mobileName();

    //定义手机颜色
    public abstract String mobileColor();

    //定义手机性能
    public abstract String mobilePerformance();

    //手机特色
    public abstract String characteristic();

}
