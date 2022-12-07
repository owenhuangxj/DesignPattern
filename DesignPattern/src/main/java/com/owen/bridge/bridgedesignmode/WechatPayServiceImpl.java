package com.owen.bridge.bridgedesignmode;
/**
 * @Author：Owen
 * @Package：com.owen.bridge.bridgemode
 * @Project：PatternDesign
 * @name：WechatPayService
 * @Date：2022/12/7 20:43
 * @Filename：WechatPayService
 */

import java.math.BigDecimal;

/**
 * 微信支付实现类
 *
 * @author OwenHuang
 * @since 2022/12/7 20:43
 */
public class WechatPayServiceImpl extends AbsPayService {

    public WechatPayServiceImpl(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public boolean transfer(long userId, String orderId, BigDecimal amount) {
        System.out.println("微信渠道支付划账开始......");
        boolean validateResult = payMode.validate(userId);
        System.out.println("微信渠道支付风险校验，用户ID：" + userId + "，交易ID：" + orderId + "，校验结果：" + validateResult);
        if (!validateResult) {
            System.out.println("微信渠道划账失败.");
            throw new RuntimeException("500");
        }
        System.out.println("微信渠道划账成功，划账金额：" + amount);
        return true;
    }
}
