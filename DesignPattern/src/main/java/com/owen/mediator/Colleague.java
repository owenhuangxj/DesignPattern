package com.owen.mediator;
/**
 * @Author：Owen
 * @Package：com.owen.mediator
 * @Project：PatternDesign
 * @name：Colleague
 * @Date：2022/12/12 20:48
 * @Filename：Colleague
 */

/**
 * 同时类持有中介者引用
 *
 * @since 2022/12/12 20:48
 * @author OwenHuang
 */
public abstract class Colleague {
    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public abstract void execute(String key);
}
