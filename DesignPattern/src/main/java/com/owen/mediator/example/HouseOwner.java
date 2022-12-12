package com.owen.mediator.example;
/**
 * @Author：Owen
 * @Package：com.owen.mediator.example
 * @Project：PatternDesign
 * @name：HouseOwner
 * @Date：2022/12/12 21:14
 * @Filename：HouseOwner
 */

/**
 * 具体的同事类—房屋的拥有者
 *
 * @author OwenHuang
 * @since 2022/12/12 21:14
 */
public class HouseOwner extends Person {
    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    // 与中介联系
    public void contact(String message) {
        mediator.contact(message, this);
    }

    // 获取信息
    public void getMessage(String message) {
        System.out.println("房主：" + name + "，获取到信息：" + message);
    }
}
