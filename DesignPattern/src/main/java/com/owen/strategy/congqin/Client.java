package com.owen.strategy.congqin;
/**
 * @Author：Owen
 * @Package：com.owen.strategy.congqin
 * @Project：PatternDesign
 * @name：Client
 * @Date：2022/12/22 20:17
 * @Filename：Client
 */

import java.util.List;

/**
 * @since 2022/12/22 20:17
 * @author OwenHuang
 */
public class Client {
    public static void main(String[] args) {
        // 模拟回执
        List<Receipt> receipts = ReceiptBuilder.getReceipts();
        // 策略上下文
        ReceiptStrategyContext context = new ReceiptStrategyContext();

        ReceiptHandleStrategyFactory.init();
        // 策略模式最主要的工作：将策略的定义，创建，使用三部分进行了解耦
        for (Receipt receipt : receipts) {
            ReceiptHandleStrategy strategy =
                    ReceiptHandleStrategyFactory.getReceiptHandleStrategy(receipt.getType());
            context.setReceiptHandleStrategy(strategy);
            context.handleReceipt(receipt);
        }
    }
}
