package com.owen.strategy.congqin;
/**
 * @Author：Owen
 * @Package：com.owen.strategy.congqin
 * @Project：PatternDesign
 * @name：ReceiptStrategy
 * @Date：2022/12/22 10:34
 * @Filename：ReceiptStrategy
 */

/**
 * 回执处理策略
 *
 * @author OwenHuang
 * @since 2022/12/22 10:34
 */
public interface ReceiptHandleStrategy {
    void handleReceipt(Receipt receipt);
}
