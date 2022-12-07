package com.owen.bridge;
/**
 * @Author：Owen
 * @Package：com.owen.bridge
 * @Project：PatternDesign
 * @name：BrigeTests
 * @Date：2022/12/7 20:33
 * @Filename：BrigeTests
 */

import com.owen.bridge.bridgedesignmode.*;
import com.owen.bridge.normal.PayChannel;
import com.owen.bridge.normal.PayMode;
import com.owen.bridge.normal.PayService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author OwenHuang
 * @since 2022/12/7 20:33
 */
public class BridgeTests {
    @Test
    public void testNormalWayPayService() {
        PayService payService = new PayService();
        payService.pay(100000001, "orderId:001", new BigDecimal("101"), PayChannel.ALI_PAY, PayMode.CYPHER);
    }

    @Test
    public void testBridgeModeWechatCypherPay() {
        AbsPayService payService = new WechatPayServiceImpl(new CypherPayMode());
        payService.transfer(100000001, "orderId:001", new BigDecimal(105));
    }

    @Test
    public void testBridgeModeWechatFingerprintPay() {
        AbsPayService payService = new WechatPayServiceImpl(new FingerPrintPayMode());
        payService.transfer(100000001, "orderId:001", new BigDecimal(105));
    }

    @Test
    public void testBridgeModeWechatFacePay() {
        AbsPayService payService = new WechatPayServiceImpl(new FacePayMode());
        payService.transfer(100000001, "orderId:001", new BigDecimal(105));
    }
}
