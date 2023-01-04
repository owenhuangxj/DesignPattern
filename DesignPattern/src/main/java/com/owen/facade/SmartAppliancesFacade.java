package com.owen.facade;
/**
 * @Author：Owen
 * @Package：com.owen.facade
 * @Project：PatternDesign
 * @name：SmartApplicancesFacade
 * @Date：2022/12/14 19:06
 * @Filename：SmartApplicancesFacade
 */

import org.apache.commons.lang3.StringUtils;

/**
 * 智能家用电器门面类
 *
 * @author OwenHuang
 * @since 2022/12/14 19:06
 */
public class SmartAppliancesFacade {
    private Light light;
    private Television television;
    private Conditioner conditioner;

    public SmartAppliancesFacade() {
        this.light = new Light();
        this.television = new Television();
        this.conditioner = new Conditioner();
    }

    public void doOrder(String order) {
        if (StringUtils.contains(order,"打开")) {
            light.on();
            television.on();
            conditioner.on();
        }else if(StringUtils.contains(order,"关闭")){
            light.off();
            television.off();
            conditioner.off();
        }else {
            System.out.println("对不起，没有听清你的指令......");
        }
    }
}
