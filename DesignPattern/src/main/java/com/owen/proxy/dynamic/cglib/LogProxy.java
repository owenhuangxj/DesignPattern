package com.owen.proxy.dynamic.cglib;
/**
 * @Author：Owen
 * @Package：com.owen.proxy.dynamic.cglib
 * @Project：PatternDesign
 * @name：LogProxy
 * @Date：2022/12/5 20:55
 * @Filename：LogProxy
 */

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author OwenHuang
 * @since 2022/12/5 20:55
 */
//@Slf4j
public class LogProxy implements MethodInterceptor {

    /**
     * 生成CGLIB动态代理类方法
     *
     * @param target 需要被代理的目标对象
     * @return 代理类对象
     */
    public Object getLogProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        // 设置被代理对象
        enhancer.setSuperclass(target.getClass());
        // 设置回调:回调类必须实现MethodInterceptor，回调方法是net.sf.cglib.proxy.MethodInterceptor.intercept
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * 回调方法
     *
     * @param obj    "this", the enhanced object ->代理对象
     * @param method intercepted Method -> 目标对象中的方法的Method实例
     * @param args   argument array; primitive types are wrapped -> 实际参数
     * @param proxy  used to invoke super (non-intercepted method); may be called as many times as needed ->
     *               代理类对象中的方法的Method实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("[" + format.format(calendar.getTime()) + "]开始事务......");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("[" + format.format(calendar.getTime()) + "]提交事务......");
        return result;
    }
}
