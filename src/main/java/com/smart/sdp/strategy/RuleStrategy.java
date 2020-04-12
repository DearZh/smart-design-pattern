package com.smart.sdp.strategy;


/**
 * 定义一个出货规则接口
 *
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-04-06
 */
@FunctionalInterface
public interface RuleStrategy {

    Integer getNumber(Integer personNumber);
}
