package com.owen.mediator;
/**
 * @Author：Owen
 * @Package：com.owen.mediator
 * @Project：PatternDesign
 * @name：MediatorTests
 * @Date：2022/12/12 21:03
 * @Filename：MediatorTests
 */

import com.owen.mediator.example.HouseOwner;
import com.owen.mediator.example.MediatorImpl;
import com.owen.mediator.example.Tenant;
import org.junit.jupiter.api.Test;

/**
 * @author OwenHuang
 * @since 2022/12/12 21:03
 */
public class MediatorTests {
    @Test
    public void testNormal() {
        Mediator mediator = new com.owen.mediator.MediatorImpl();
        Colleague colleague1 = new ConcreteColleagueA(mediator);
        colleague1.execute("Colleague-A");
        Colleague colleague2 = new ConcreteColleagueB(mediator);
        colleague2.execute("Colleague-B");
    }

    @Test
    public void testTenant() {

        MediatorImpl mediator = new MediatorImpl();
        Tenant tenant = new Tenant("李四", mediator);
        HouseOwner houseOwner = new HouseOwner("张三", mediator);
        mediator.setTenant(tenant);
        mediator.setHouseOwner(houseOwner);
        tenant.contact("我要租房，需要在百草路附近租一个2室一厅.");
    }
}
