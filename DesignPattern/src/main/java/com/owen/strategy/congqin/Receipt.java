package com.owen.strategy.congqin;
/**
 * @Author：Owen
 * @Package：com.owen.strategy.congqin
 * @Project：PatternDesign
 * @name：Receipt
 * @Date：2022/12/22 10:45
 * @Filename：Receipt
 */

/**
 * @author OwenHuang
 * @since 2022/12/22 10:45
 */

public class Receipt {
    /**
     * 回执消息
     */
    private String message;
    /**
     * 回执类型
     */
    private String type;

    public Receipt(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }
}
