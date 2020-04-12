package com.smart.sdp.strategy;

/**
 * 对于非周末情况下的出货规则
 *
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-04-06
 */
public class WrongWeekendRule implements RuleStrategy {
    @Override
    public Integer getNumber(Integer personNumber) {

        //非周末的情况下，每人抢到手机的几率为 1000分之一，制造出更加难以抢到的错觉

        return personNumber / 1000;
    }
}
