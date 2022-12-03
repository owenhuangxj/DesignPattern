package com.owen.singleton;
/**
 * @Author：Owen
 * @Package：com.owen.singleton
 * @Project：PatternDesign
 * @name：DoubleCheckLockSingleton
 * @Date：2022/12/2 21:13
 * @Filename：DoubleCheckLockSingleton
 */

import java.io.Serializable;

/**
 * @author OwenHuang
 * @since 2022/12/2 21:13
 */
public class DoubleCheckLockSingleton implements Serializable {

    private volatile static DoubleCheckLockSingleton instance;

    private DoubleCheckLockSingleton() {
        if (instance != null) {
            throw new RuntimeException("Singleton instance is not allowed to be prototyped.");
        }else {
            /**
             * 通过getInstance方法获取实例时正常情况构造方法只被调用一次，如果是通过反射的方式创建对象就无法保证单例，
             * 此处确保通过反射获取实例时对象也只会生成一个，第二次之后通过反射调用时会抛异常
             * */
            instance = this;
        }
    }

    public static DoubleCheckLockSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (instance == null) {
                    /**
                     * JVM中如下对象创建顺序
                     * 1、分配内存空间
                     * 2、初始化对象
                     * 3、将引用instance指向分配好的内存空间
                     * 但是JVM会对这个步骤进行优化，可能会指令重排序，变成1->3->2，造成多线程情况时拿到没有完全创建好的单例对象
                     */
                    instance = new DoubleCheckLockSingleton();
                }
            }
        }
        return instance;
    }

    /**
     * 反序列化时会被调用来创建对象，为了确保单例，重写readResolve方法，调用单例获取方法确保单例
     * @return 实例对象
     */
    private Object readResolve() {
        return getInstance();
    }
}