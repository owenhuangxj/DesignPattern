package com.owen.prototype;
/**
 * @Author：Owen
 * @Package：com.owen.prototype
 * @Project：PatternDesign
 * @name：CloneTests
 * @Date：2022/12/4 12:58
 * @Filename：CloneTests
 */

import com.owen.prototype.clone.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Collections;

/**
 * @author OwenHuang
 * @since 2022/12/4 12:58
 */
public class CloneTests {

    private Person buildPerson() {
        Person person = new Person();
        person.setId(12350L);
        person.setName("Owen");
        Address address = new Address();
        address.setNation("China");
        address.setProvince("sichuan");
        person.setAddress(address);
        return person;
    }

    private Student buildStudent() {
        Student student = new Student();
        student.setId(12350L);
        student.setName("Owen");
        Address address = new Address();
        address.setNation("China");
        address.setProvince("sichuan");
        student.setAddress(address);
        Teacher teacher = new Teacher();
        teacher.setId(10000);
        teacher.setName("马老师");
        Course course = new Course();
        course.setTeachers(Collections.singletonList(teacher));
        student.setCourses(Collections.singletonList(course ));
        return student;
    }

    /**
     * 浅克隆：由于调用的是目标对象的clone方法，所以目标对象中的属性不需要实现Cloneable接口
     * 浅克隆会复制那些类型为引用数据类型的属性/字段的地址
     * Student的构造方法只被调用了一次-->clone的时候是通过2进制的方式实现的，没有调用构造方法来复制对象
     *
     * @throws CloneNotSupportedException 不支持克隆异常，如果被复制的类没有实现标记接口Cloneable就会报此错误
     */
    @Test
    public void testShallowClone() throws CloneNotSupportedException {
        Student student = buildStudent();
        Student clone = student.clone();
        // 克隆出来的对象不是一个对象
        Assertions.assertTrue(student != clone);
        Assertions.assertTrue(student.getId() == clone.getId());
        Assertions.assertTrue(student.getName() == clone.getName());
        // 克隆出来的引用类型的属性只是增加了一个引用类型（变量）指向内存中同一个地址
        Assertions.assertTrue(student.getAddress() == clone.getAddress());
        Assertions.assertEquals(clone.getAddress().getNation(), "China");

        // 一个引用的值修改了，另外一个引用的值也跟着一起修改
        clone.getAddress().setNation("中国");
        Assertions.assertEquals(student.getAddress().getNation(), "中国");

        Assertions.assertNotNull(clone.getCourses());
        Assertions.assertNotNull(clone.getCourses().get(0));
        Assertions.assertNotNull(clone.getCourses().get(0).getTeachers());
        Assertions.assertNotNull(clone.getCourses().get(0).getTeachers().get(0));
        Assertions.assertNotNull(clone.getCourses().get(0).getTeachers().get(0).getName());
        Assertions.assertEquals(clone.getCourses().get(0).getTeachers().get(0).getName(),"马老师");
    }

    /**
     * 深度克隆
     * 深度克隆引用類型的数据时是新建一个同类型的数据，值相同，两个引用指向不同的内存地址
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testDeepClone() throws IOException, ClassNotFoundException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("deep-clone.txt"));
        Person person = buildPerson();
        outputStream.writeObject(person);
        outputStream.flush();
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("deep-clone.txt"));
        Person clone = (Person) inputStream.readObject();
        System.out.println(clone);
        inputStream.close();

        // 深度克隆出来的引用类型的属性是不同的内存空间（地址不相同）
        Assertions.assertNotEquals(person.getAddress(), clone.getAddress());
    }
}
