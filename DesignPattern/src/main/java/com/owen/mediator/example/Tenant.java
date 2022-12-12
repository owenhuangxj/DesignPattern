package com.owen.mediator.example;
/**
 * @Author：Owen
 * @Package：com.owen.mediator.example
 * @Project：PatternDesign
 * @name：Tenant
 * @Date：2022/12/12 21:17
 * @Filename：Tenant
 */

/**
 * @author OwenHuang
 * @since 2022/12/12 21:17
 */
public class Tenant extends Person {
    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void contact(String message) {
        mediator.contact(message, this);
    }

    public void getMessage(String message) {
        System.out.println("租房者：" + name + "，获取到消息：" + message);
    }

}
