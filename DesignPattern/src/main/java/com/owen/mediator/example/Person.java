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
    protected Mediator mediator;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
