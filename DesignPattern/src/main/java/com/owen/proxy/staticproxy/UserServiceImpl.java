package com.owen.proxy.staticproxy;
/**
 * @Author：Owen
 * @Package：com.owen.proxy
 * @Project：PatternDesign
 * @name：UserImpl
 * @Date：2022/12/4 21:01
 * @Filename：UserImpl
 */

import com.owen.proxy.User;
import com.owen.proxy.UserService;

/**
 * @author OwenHuang
 * @since 2022/12/4 21:01
 */
public class UserServiceImpl implements UserService {
    @Override
    public int save(User user) {
        System.out.println("用户信息：" + user + "，保存成功。");
        return 1;
    }
}
