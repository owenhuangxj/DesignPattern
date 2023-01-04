package com.owen;
/**
 * @Author：Owen
 * @Package：com.owen
 * @Project：lambda-stream
 * @name：Husband
 * @Date：2023/1/1 20:13
 * @Filename：Husband
 */

/**
 * @author OwenHuang
 * @since 2023/1/1 20:13
 */
public class Husband {
    public void buyHouse() {
        System.out.println("北京二环内买一套四合院！");
    }

    public void marry(Richable richable) {
        richable.buy();
    }

    /**
     * 同理：buyHouse与Richable兼容：
     * buyHouse非入参和出参类型与Richable唯一的一个抽象方法的入参和出参匹配
     */
    public void test() {
        marry(this::buyHouse);
    }
}
