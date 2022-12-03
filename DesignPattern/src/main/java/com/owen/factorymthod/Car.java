package com.owen.factorymthod;
/**
 * @Author：Owen
 * @Package：com.owen.factorymthod
 * @Project：PatternDesign
 * @name：Car
 * @Date：2022/11/30 22:17
 * @Filename：Car
 */

/**
 * @author OwenHuang
 * @since 2022/11/30 22:17
 */
public class Car implements Movable {
    @Override
    public void go() {
        System.out.println("Car moving......");
    }
}
