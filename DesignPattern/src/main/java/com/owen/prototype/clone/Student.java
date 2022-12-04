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
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author OwenHuang
 * @since 2022/12/4 13:34
 */
@Getter
@Setter
public class Student implements Cloneable {
    private Long id;
    private String name;

    private Address address;

    private List<Course> courses = new ArrayList<>();

    public Student() {
        super();
        System.out.println("Student的构造方法被调用......");
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        System.out.println("Student的克隆方法被调用了......");
        return (Student) super.clone();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
