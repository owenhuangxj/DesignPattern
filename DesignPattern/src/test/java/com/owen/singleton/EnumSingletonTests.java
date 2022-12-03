package com.owen.singleton;
/**
 * @Author：Owen
 * @Package：com.owen.singleton
 * @Project：PatternDesign
 * @name：EnumSingletonTests
 * @Date：2022/11/29 21:19
 * @Filename：EnumSingletonTests
 */

import org.junit.jupiter.api.Test;

/**
 * @since 2022/11/29 21:19
 * @author OwenHuang
 */
public class EnumSingletonTests {
    @Test
    public void test(){
        for (int idx = 0; idx < 1000; idx++) {
            new Thread(()-> System.out.println(EnumSingleton.INSTANCE.hashCode())).start();
        }
    }
}
