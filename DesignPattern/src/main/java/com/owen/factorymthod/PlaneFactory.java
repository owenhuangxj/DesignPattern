package com.owen.factorymthod;
/**
 * @Author：Owen
 * @Package：com.owen.factorymthod
 * @Project：PatternDesign
 * @name：PlaneFactory
 * @Date：2022/11/30 22:20
 * @Filename：PlaneFactory
 */

/**
 * @author OwenHuang
 * @since 2022/11/30 22:20
 */
public class PlaneFactory implements MovableFactory {
    @Override
    public Movable create() {
        return new Plane();
    }
}
