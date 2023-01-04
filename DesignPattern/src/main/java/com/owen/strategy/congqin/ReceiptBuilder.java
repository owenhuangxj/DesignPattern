package com.owen.strategy.congqin;
/**
 * @Author：Owen
 * @Package：com.owen.strategy.congqin
 * @Project：PatternDesign
 * @name：ReceiptBuilder
 * @Date：2022/12/22 20:14
 * @Filename：ReceiptBuilder
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @since 2022/12/22 20:14
 * @author OwenHuang
 */
public class ReceiptBuilder {
    public static List<Receipt> getReceipts(){
        // 模拟回执消息
        List<Receipt> receipts = new ArrayList<>();
        receipts.add(new Receipt("MT1101回执消息","MT1101"));
        receipts.add(new Receipt("MT2101回执消息","MT2101"));
        return receipts;
    }
}
