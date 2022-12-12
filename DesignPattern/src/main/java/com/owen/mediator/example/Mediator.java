package com.owen.mediator.example;
/**
 * @Author：Owen
 * @Package：com.owen.mediator.example
 * @Project：PatternDesign
 * @name：Mediator
 * @Date：2022/12/12 21:10
 * @Filename：Mediator
 */


/**
 * 抽象中介者
 *
 * @author OwenHuang
 * @since 2022/12/12 21:10
 */
public abstract class Mediator {
    // 创建联络方法
    public abstract void contact(String message, Person person);

}
