package com.owen.prototype.clone;
/**
 * @Author：Owen
 * @Package：com.owen.prototype.clone
 * @Project：PatternDesign
 * @name：Person
 * @Date：2022/12/4 12:56
 * @Filename：Person
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author OwenHuang
 * @since 2022/12/4 12:56
 */
@Getter
@Setter
public class Person implements Serializable {
    private Long id;
    private String name;

    private Address address;

    public Person() {
        super();
        System.out.println("Person的构造方法被调用......");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
