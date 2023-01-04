package com.owen.strategy.congqin;
/**
 * @Author：Owen
 * @Package：com.owen.strategy.congqin
 * @Project：PatternDesign
 * @name：ReceiptStrategyContext
 * @Date：2022/12/22 20:07
 * @Filename：ReceiptStrategyContext
 */

/**
 * 上下文类，持有策略接口，决定执行哪一个具体的策略类
 *
 * @author OwenHuang
 * @since 2022/12/22 20:07
 */
public class ReceiptStrategyContext {
    private ReceiptHandleStrategy receiptHandleStrategy;

    public void setReceiptHandleStrategy(ReceiptHandleStrategy receiptHandleStrategy) {
        this.receiptHandleStrategy = receiptHandleStrategy;
    }

    public void handleReceipt(Receipt receipt) {
        if (receipt != null) {
            receiptHandleStrategy.handleReceipt(receipt);
        }
    }
}
