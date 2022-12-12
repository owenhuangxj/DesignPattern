package com.owen.mediator.example;
/**
 * @Author：Owen
 * @Package：com.owen.mediator.example
 * @Project：PatternDesign
 * @name：MediatorStructure
 * @Date：2022/12/12 21:20
 * @Filename：MediatorStructure
 */

/**
 * @author OwenHuang
 * @since 2022/12/12 21:20
 */
public class MediatorImpl extends Mediator {

    private HouseOwner houseOwner;

    private Tenant tenant;

    public MediatorImpl() {
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public void contact(String message, Person person) {
        // 如果是房主，则租房者获得信息
        if (person == houseOwner) {
            tenant.getMessage(message);
        } else {
            // 如果是租房者，则房主获得信息
            houseOwner.getMessage(message);
        }
    }
}
