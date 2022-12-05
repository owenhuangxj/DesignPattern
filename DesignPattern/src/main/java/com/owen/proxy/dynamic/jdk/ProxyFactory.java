package com.owen.proxy.dynamic.jdk;
/**
 * @Author：Owen
 * @Package：com.owen.proxy.dynamic
 * @Project：PatternDesign
 * @name：ProxyFactory
 * @Date：2022/12/4 21:36
 * @Filename：ProxyFactory
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author OwenHuang
 * @since 2022/12/4 21:36
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     *
                     * @param proxy the proxy instance that the method was invoked on ->代理对象
                     *
                     * @param method the {@code Method} instance corresponding to
                     * the interface method invoked on the proxy instance.The declaring
                     * class of the {@code Method} object will be the interface that
                     * the method was declared in, which may be a superinterface of the
                     * proxy interface that the proxy class inherits the method through. ->对应于在被代理对象上调用的接口方法实例
                     *
                     * @param args an array of objects containing the values of the
                     * arguments passed in the method invocation on the proxy instance,
                     * or {@code null} if interface method takes no arguments.
                     * Arguments of primitive types are wrapped in instances of the
                     * appropriate primitive wrapper class, such as
                     * {@code java.lang.Integer} or {@code java.lang.Boolean}. ->应用与被代理对象在调用接口方法时传递的实际参数
                     *
                     * @return 被调用的目标方法的返回值，沒有返回值则返回null
                     * @throws Throwable 异常
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务......");
                        Object result = method.invoke(target, args);
                        System.out.println("目标方法[" + method + "]被调用......");
                        System.out.println("提交事务......");
                        return result;
                    }
                }
        );
    }
}
