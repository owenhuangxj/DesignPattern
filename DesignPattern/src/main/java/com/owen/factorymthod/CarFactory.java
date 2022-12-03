package com.owen.factorymthod;
/**
 * @Author：Owen
 * @Package：com.owen.factorymthod
 * @Project：PatternDesign
 * @name：CarFactory
 * @Date：2022/11/30 22:19
 * @Filename：CarFactory
 */

/**
 * @since 2022/11/30 22:19
 * @author OwenHuang
 */
public class CarFactory implements MovableFactory{
    @Override
    public Movable create() {
        return new Car();
    }
}
