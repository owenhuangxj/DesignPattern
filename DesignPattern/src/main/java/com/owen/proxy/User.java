package com.owen.proxy;
/**
 * @Author：Owen
 * @Package：com.owen.proxy
 * @Project：PatternDesign
 * @name：User
 * @Date：2022/12/4 21:00
 * @Filename：User
 */

import lombok.Builder;
import lombok.ToString;

/**
 * @author OwenHuang
 * @since 2022/12/4 21:00
 */
@Builder
@ToString
public class User {
    private long userId;
    private String userName;

    public User(long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
