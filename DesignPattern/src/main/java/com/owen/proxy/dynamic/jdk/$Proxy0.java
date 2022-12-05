package com.owen.proxy.dynamic.jdk;

import com.owen.proxy.User;
import com.owen.proxy.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 通过arthas获取到的动态代理生成的类
 * 通过arthas获取动态代理类的时候需要在main方法里面启动，在测试方法里面无法获取对应的代码
 *     public static void main(String[] args) {
 *         UserServiceImpl target = new UserServiceImpl();
 *         UserService proxy = (UserService) new ProxyFactory(target).getProxyInstance();
 *         System.out.println(proxy.getClass());
 *         int result = proxy.save(User.builder().userId(500000).userName("OwenHuang").build());
 *         Assertions.assertEquals(result, 1);
 *         while (true){
 *         }
 *     }
 * arthas安装路径：D:\Arthas
 *
 *
 */
public final class $Proxy0 extends Proxy implements UserService {
    private static Method m1;
    private static Method m2;
    private static Method m3;
    private static Method m0;

    public $Proxy0(InvocationHandler invocationHandler) {
        super(invocationHandler);
    }

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
            m3 = Class.forName("com.owen.proxy.UserService").getMethod("save", Class.forName("com.owen.proxy.User"));
            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
            // return;
        } catch (NoSuchMethodException noSuchMethodException) {
            throw new NoSuchMethodError(noSuchMethodException.getMessage());
        } catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }

    public final boolean equals(Object object) {
        try {
            return (Boolean) this.h.invoke(this, m1, new Object[]{object});
        } catch (Error | RuntimeException throwable) {
            throw throwable;
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final String toString() {
        try {
            return (String) this.h.invoke(this, m2, null);
        } catch (Error | RuntimeException throwable) {
            throw throwable;
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final int hashCode() {
        try {
            return (Integer) this.h.invoke(this, m0, null);
        } catch (Error | RuntimeException throwable) {
            throw throwable;
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final int save(User user) {
        try {
            return (Integer) this.h.invoke(this, m3, new Object[]{user});
        } catch (Error | RuntimeException throwable) {
            throw throwable;
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }
}