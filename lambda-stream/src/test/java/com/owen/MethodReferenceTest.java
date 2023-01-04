package com.owen;
/**
 * @Author：Owen
 * @Package：com.owen
 * @Project：lambda-stream
 * @name：MethodReferenceTest
 * @Date：2023/1/1 19:13
 * @Filename：MethodReferenceTest
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author OwenHuang
 * @since 2023/1/1 19:13
 */
public class MethodReferenceTest {

    public static int getAbs(int number, Calculatable calculatable) {
        return calculatable.abs(number);
    }

    /**
     * 引用静态方法
     */
    @Test
    public void testReferenceStaticMethod() {
        /**
         * 为什么getAbs的第二个参数(类型为Calculatable)可以引用Math的静态方法：
         * 因为Math的abs入参和出参与Calculatable中的abs方法的入参和出参类型一样
         */
        int abs = getAbs(-40, Math::abs);
        System.out.println("绝对值：" + abs);
    }


    public void printUserWithName(String name, UserBuilder userBuilder) {
        System.out.println(userBuilder.getUser(name));
    }

    /**
     * 引用构造器方法
     */
    @Test
    public void testReferenceConstruct() {
        /**
         * 因为UserBuilder入参是String类型，所以如果要引用User的构造方法需要User提供一个String类型为入参的构造器
         */
        printUserWithName("Owen", User::new);
    }

    public void printString(String str, Printable printable) {
        printable.print(str);
    }

    /**
     * 对象方法的引用
     */
    @Test
    public void testReferenceObjectMethod() {
        /**
         * 因为com.owen.ObjectMethodReference#doUppercaseAndPrint(java.lang.String) 与Printable兼容，
         * 注意这里的兼容是指被引用方法(com.owen.ObjectMethodReference#doUppercaseAndPrint(java.lang.String))的入参与Printable一致
         * 并且如果Printable没有返回参数的话被引用方法是应许有返回值的，但是如果Printable有返回值的话被引用方法的返回值必须与Printable保持一致
         * 所以需要传入Printable的时候可以直接引用com.owen.ObjectMethodReference#doUppercaseAndPrint(java.lang.String)
         */
        printString("Hello,I am Owen!", new ObjectMethodReference()::doUppercaseAndPrint);
    }

    @Test
    public void testReferenceFatherMethod() {
        /**
         * 绕来绕去只是为了演示super::methodName的方式引用父类的方法
         */
        new Man().test();
    }

    @Test
    public void testReferenceThisMethod() {

        /**
         * 与testReferenceFatherMethod一样绕来绕去只是为了演示this::methodName的方式引用本类的方法
         */
        new Husband().test();
    }

    public int[] createIntArray(int length, IntArrayBuilder intArrayBuilder) {
        return intArrayBuilder.build(length);
    }

    /**
     * 数组的方法引用有且只有"构造器引用"
     */
    @Test
    public void testReferenceArrayNewMethod() {
        Assertions.assertEquals(createIntArray(10, int[]::new).length, 10);
    }

}
