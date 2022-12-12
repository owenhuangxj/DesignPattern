package com.owen.bridge.bridgedesignmode;
/**
 * @Author：Owen
 * @Package：com.owen.bridge.bridgemode
 * @Project：PatternDesign
 * @name：PayService
 * @Date：2022/12/7 20:37
 * @Filename：PayService
 */

import java.math.BigDecimal;

/**
 * 抽象支付类
 * 桥接模式：
 *  1、支付渠道拥有支付模式的引用
 *  2、支付渠道通过抽象类来引用支付方式
 * @author OwenHuang
 * @since 2022/12/7 20:37
 */
public abstract class AbsPayService {
    protected IPayMode payMode;

    public AbsPayService(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract boolean transfer(long userId, String orderId, BigDecimal amount);
}
