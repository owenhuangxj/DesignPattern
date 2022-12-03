package com.owen.factorymthod;
/**
 * @Author：Owen
 * @Package：com.owen.factorymthod
 * @Project：PatternDesign
 * @name：Plane
 * @Date：2022/11/30 22:17
 * @Filename：Plane
 */

/**
 * @since 2022/11/30 22:17
 * @author OwenHuang
 */
public class Plane implements Movable{
    @Override
    public void go() {
        System.out.println("Plane flying......");
    }
}
