package com.owen.proxy;
/**
 * @Author：Owen
 * @Package：com.owen.proxy
 * @Project：PatternDesign
 * @name：ProxyTests
 * @Date：2022/12/4 21:32
 * @Filename：ProxyTests
 */

import com.owen.proxy.dynamic.cglib.LogProxy;
import com.owen.proxy.dynamic.jdk.ProxyFactory;
import com.owen.proxy.staticproxy.UserServiceImpl;
import com.owen.proxy.staticproxy.UserServiceProxy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author OwenHuang
 * @since 2022/12/4 21:32
 */
public class ProxyTests {

    private User buildUser() {
        return User.builder().userId(500000).userName("OwenHuang").build();
    }

    @Test
    public void testStaticProxy() {
        UserServiceProxy proxy = new UserServiceProxy(new UserServiceImpl());
        Assertions.assertEquals(proxy.save(User.builder().userId(12345).userName("Owen").build()), 1);
    }

    @Test
    void testDynamicProxy() {
        UserService target = new UserServiceImpl();
        UserService proxy = (UserService) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        int result = proxy.save(buildUser());
        Assertions.assertEquals(result, 1);
        while (true) {

        }
    }

    @Test
    void testCglibProxy() {
        UserService userService = new UserServiceImpl();
        System.out.println(userService);
        UserService proxy = (UserService) new LogProxy().getLogProxy(userService);
        System.out.println(proxy);
        proxy.save(buildUser());
    }

}
