package com.owen.singleton;
/**
 * @Author：Owen
 * @Package：com.owen.singleton.factory
 * @Project：PatternDesign
 * @name：InnerClass
 * @Date：2022/11/28 21:54
 * @Filename：InnerClass
 */

/**
 * @author OwenHuang
 * @since 2022/11/28 21:54
 */
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {
        if (InstanceHolder.INSTANCE != null) {
            throw new RuntimeException("不允许单例构造器被重复调用创建对象.");
        }
        System.out.println("外部类的私有构造方法被调用了......");
    }

    private static int staticVariable = 5;

    static {
        // 静态代码块中访问某个静态变量（类变量）时必须保证静态代码块在这个被访问的静态变量之后，否则会报"非法前向引用"错误
        System.out.println("The value of static field staticVariable in static initialization block : " + staticVariable);
    }

    private static final class InstanceHolder {
        static {
            System.out.println("内部类的静态代码块被加载了......");
        }

        public static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
}