package com.owen.mediator;
/**
 * @Author：Owen
 * @Package：com.owen.mediator
 * @Project：PatternDesign
 * @name：ConcreteMediatorA
 * @Date：2022/12/12 21:00
 * @Filename：ConcreteMediatorA
 */

/**
 * @author OwenHuang
 * @since 2022/12/12 21:00
 */
public class ConcreteColleagueA extends Colleague {
    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void execute(String key) {
        System.out.println("在具体同事类A中，通过中介者执行！");
        getMediator().apply(key);
    }
}
