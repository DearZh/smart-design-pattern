package com.smart.sdp.strategy;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-04-06
 */
public class Main {

    public static void main(String[] args) {

        //预约人数2W人
        Integer personNumber = 20000;
        RuleStrategy ruleStrategy = null;
        if (isWeek()) {
            ruleStrategy = new WeekendRule();
            System.out.println("当前预供货量为：" + ruleStrategy.getNumber(personNumber));
        } else {
            ruleStrategy = new WrongWeekendRule();
            System.out.println("当前预供货量为：" + ruleStrategy.getNumber(personNumber));
        }


        //JDK1.8 可以利用函数式接口来写,然后自定义供货规则

        if (isWeek()) {
            ruleStrategy = num -> (num / 20);
            System.out.println("当前预供货量为：" + ruleStrategy.getNumber(personNumber));
        } else {
            ruleStrategy = num -> {
                //根据提前预约的人数多少，就供货多少
                return num / 1;
            };
            System.out.println("当前预供货量为：" + ruleStrategy.getNumber(personNumber));
        }
        //上述的就是一个策略模式，还是利用接口来做抽象，
    }

    /**
     * @description:
     * @param: []
     * @return: boolean true表示当前是周末，false表示非周末
     * @author: Arnold.zhao
     * @date: 2020/4/6
     */
    public static boolean isWeek() {
        Date bdate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(bdate);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        } else {
            return false;
        }
    }
}
