package com.owen.proxy;
/**
 * @Author：Owen
 * @Package：com.owen.proxy
 * @Project：PatternDesign
 * @name：ProxyTests
 * @Date：2022/12/4 21:32
 * @Filename：ProxyTests
 */

import com.owen.proxy.dynamic.ProxyFactory;
import com.owen.proxy.staticproxy.UserServiceImpl;
import com.owen.proxy.staticproxy.UserServiceProxy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author OwenHuang
 * @since 2022/12/4 21:32
 */
public class ProxyTests {
    @Test
    public void testStaticProxy() {
        UserServiceProxy proxy = new UserServiceProxy(new UserServiceImpl());
        Assertions.assertEquals(proxy.save(User.builder().userId(12345).userName("Owen").build()), 1);
    }

    @Test
    void testDynamicProxy() {
        UserService proxy = (UserService) new ProxyFactory(new UserServiceImpl()).getProxyInstance();
        System.out.println(proxy.getClass());
        int result = proxy.save(User.builder().userId(500000).userName("OwenHuang").build());
        Assertions.assertEquals(result, 1);
    }
}
