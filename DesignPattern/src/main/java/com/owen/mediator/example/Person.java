package com.owen.mediator.example;
/**
 * @Author：Owen
 * @Package：com.owen.mediator.example
 * @Project：PatternDesign
 * @name：Person
 * @Date：2022/12/12 21:12
 * @Filename：Person
 */

/**
 * @author OwenHuang
 * @since 2022/12/12 21:12
 */
public abstract class Person {
    protected String name;
    /**
     * 拥有Mediator对象，属于聚合关系：被依赖对象是通过构造方法而不是自己new出来的，所以是聚合而不是组合
     */
    protected Mediator mediator;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
