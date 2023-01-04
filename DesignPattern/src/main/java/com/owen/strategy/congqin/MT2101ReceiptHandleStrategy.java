package com.owen.strategy.congqin;
/**
 * @Author：Owen
 * @Package：com.owen.strategy.congqin
 * @Project：PatternDesign
 * @name：MT1101ReceiptHandleStrategy
 * @Date：2022/12/22 10:49
 * @Filename：MT1101ReceiptHandleStrategy
 */

/**
 * 具体的策略类
 *
 * @author OwenHuang
 * @since 2022/12/22 10:49
 */
public class MT2101ReceiptHandleStrategy implements ReceiptHandleStrategy {
    @Override
    public void handleReceipt(Receipt receipt) {
        System.out.println("解析报文MT2101： " + receipt.getMessage());
    }
}
