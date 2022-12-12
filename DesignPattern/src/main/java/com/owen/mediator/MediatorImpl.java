package com.owen.mediator;
/**
 * @Author：Owen
 * @Package：com.owen.mediator
 * @Project：PatternDesign
 * @name：MediatorImpl
 * @Date：2022/12/12 20:47
 * @Filename：MediatorImpl
 */

/**
 * 中介者实现类
 *
 * @author OwenHuang
 * @since 2022/12/12 20:47
 */
public class MediatorImpl extends Mediator {
    @Override
    public void apply(String key) {
        System.out.println("最终中介者执行的操作，key为：" + key);
    }
}
