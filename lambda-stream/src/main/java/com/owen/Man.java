package com.owen;
/**
 * @Author：Owen
 * @Package：com.owen
 * @Project：lambda-stream
 * @name：Man
 * @Date：2023/1/1 19:49
 * @Filename：Man
 */

/**
 * @author OwenHuang
 * @since 2023/1/1 19:49
 */
public class Man extends Human {
    @Override
    public void sayHello() {
        System.out.println("Hello,I am man.");
    }

    private void method(Greetable greetable) {
        greetable.greet();
    }

    public void test() {
        method(super::sayHello);
    }
}
