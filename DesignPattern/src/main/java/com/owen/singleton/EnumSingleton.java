package com.owen.singleton;
/**
 * @Author：Owen
 * @Package：com.owen.singleton
 * @Project：PatternDesign
 * @name：EnumClass
 * @Date：2022/11/28 22:15
 * @Filename：EnumClass
 */

/**
 * @since 2022/11/28 22:15
 * @author OwenHuang 策略
 */
public enum EnumSingleton {
    INSTANCE;
    EnumSingleton(){
        /**
         * 枚举类的构造方法只会被调用一次
         */
        System.out.println("枚举类的构造方法......");
        // 单例业务写在枚举类中
    }
}
