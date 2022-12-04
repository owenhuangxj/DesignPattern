package com.owen.proxy.staticproxy;
/**
 * @Author：Owen
 * @Package：com.owen.proxy
 * @Project：PatternDesign
 * @name：UserServiceProxy
 * @Date：2022/12/4 21:03
 * @Filename：UserServiceProxy
 */

import com.owen.proxy.User;
import com.owen.proxy.UserService;

/**
 * @author OwenHuang
 * @since 2022/12/4 21:03
 */
public class UserServiceProxy implements UserService {
    private UserService target;

    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    @Override
    public int save(User user) {
        System.out.println("保存用户之前，打开事务");
        int result = target.save(user);
        System.out.println("保存用户成功，关闭事务");
        return result;
    }
}
