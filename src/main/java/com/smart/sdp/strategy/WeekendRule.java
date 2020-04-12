package com.smart.sdp.strategy;

import java.util.function.Supplier;

/**
 * 对于周末情况下的出货规则
 *
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-04-06
 */
public class WeekendRule implements RuleStrategy {
    @Override
    public Integer getNumber(Integer personNumber) {

        //周末情况下抢到手机的几率为预约人数的 百分之一 ；

        return personNumber / 100;
    }
}
