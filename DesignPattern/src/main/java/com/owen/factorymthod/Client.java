package com.owen.factorymthod;
/**
 * @Author：Owen
 * @Package：com.owen.factorymthod
 * @Project：PatternDesign
 * @name：Client
 * @Date：2022/11/30 22:21
 * @Filename：Client
 */

/**
 * @since 2022/11/30 22:21
 * @author OwenHuang
 */
public class Client {
    public static void main(String[] args) {
        MovableFactory factory = new PlaneFactory();
        Movable movable = factory.create();
        movable.go();
    }
}
