package com.owen.bridge.normal;
/**
 * @Author：Owen
 * @Package：com.owen.bridge
 * @Project：PatternDesign
 * @name：PayService
 * @Date：2022/12/7 20:14
 * @Filename：PayService
 */

import java.math.BigDecimal;

/**
 * 支付通用实现方式
 *
 * @author OwenHuang
 * @since 2022/12/7 20:14
 */
public class PayService {

    public boolean pay(long userId, String orderId, BigDecimal amount, PayChannel payChannel, PayMode payMode) {
        if (PayChannel.ALI_PAY == payChannel) {
            System.out.println("开始支付宝支付");
            if (PayMode.FACE == payMode) {
                System.out.println("人脸识别支付，用户：" + userId + "，订单号：" + orderId + "，金额：" + amount);
            } else if (PayMode.CYPHER == payMode) {
                System.out.println("账号密码支付，用户：" + userId + "，订单号：" + orderId + "，金额：" + amount);
            } else if (PayMode.FINGER_PRINT == payMode) {
                System.out.println("指纹识别支付，用户：" + userId + "，订单号：" + orderId + "，金额：" + amount);
            }
        }
        if (PayChannel.WE_CHAT == payChannel) {
            System.out.println("开始微信支付");
            if (PayMode.FACE == payMode) {
                System.out.println("人脸识别支付，用户：" + userId + "，订单号：" + orderId + "，金额：" + amount);
            } else if (PayMode.CYPHER == payMode) {
                System.out.println("账号密码支付，用户：" + userId + "，订单号：" + orderId + "，金额：" + amount);
            } else if (PayMode.FINGER_PRINT == payMode) {
                System.out.println("指纹识别支付，用户：" + userId + "，订单号：" + orderId + "，金额：" + amount);
            }
        }
        return true;
    }
}
