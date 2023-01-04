package com.owen;
/**
 * @Author：Owen
 * @Package：com.owen
 * @Project：lambda-stream
 * @name：Test
 * @Date：2022/12/31 19:55
 * @Filename：Test
 */

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author OwenHuang
 * @since 2022/12/31 19:55
 */
public class LambdaTest {
    @Test
    public void testDifferentGetObjectWay() {

        System.out.println("实现类获取到User:" + new UserBeanFactory().getObject());

        // 通过匿名内部类的方式获取User，此时idea会提示可以将匿名内部类转换为lambda的方式，如下面的获取方式即时Lambda的方式
        Object user = new BeanFactory() {
            @Override
            public Object getObject() {
                return new User(2, "Owen", 40);
            }
        }.getObject();

        System.out.println("匿名内部类方式获取User:" + user);


        /**
         * java的FunctionalInterface接口让Function成为了java的一等公民，java在1.8支持lambda之前参数只能是类型（类，接口，枚举等），
         * 引入函数式接口（接口中只有一个接口是抽象接口）让java支持函数式编程，大家可以把lambda看成函数即可
         * Lambda表达式的本质：函数式接口的匿名子类的匿名对象
         */
        System.out.println("Lambda方式获取到User:" + ((BeanFactory) () -> new User(3, "Owen", 40)).getObject());
    }

    @Test
    public void testMathOperation() {
        MathOperation addOperation = ((int i1, int i2) -> i1 + i2);
        System.out.println("求和结果：" + addOperation.operation(1, 2));

        /**
         * 参数类型可以省略
         */
        MathOperation subtractOperation = ((i1, i2) -> i1 - i2);
        System.out.println("求差的结果：" + subtractOperation.operation(1, 2));
    }

    @Test
    public void testCommonFunctionalInterfaces() {
        // Runnable
        new Thread(() -> System.out.println("[" + Thread.currentThread().getName() + "]线程已启动"));
        // Supplier
        // Supplier的demo包含Stream的一些操作，对新手比较难
        System.out.println("最大值：" + getMax(() -> Stream.of(1, 2, 15, 23, 3, 9, 10, 26).max(Comparator.comparingInt(o -> o)).orElse(Integer.MIN_VALUE)));
        // Consumer
        consumeString(str -> System.out.println("Hello：" + str));
        consumeString(str -> System.out.println("Hello," + str.toLowerCase()),
                str -> System.out.println("Hello," + str.toUpperCase()));
        // Comparator:字符串根据长度排序，长的在后面
        System.out.println(Stream.of("ab", "123", "87987", "Owen", "Huangxianjun").max(Comparator.comparingInt(String::length)).orElse("Nothing"));
        // Predicate
        System.out.println("条件都满足：" + and("Huangxianjun", str -> str.contains("Huang"), str -> str.length() > 5));
        System.out.println("有一个条件满足：" + or("Huangxianjun", str -> str.contains("Huang"), str -> str.length() > 20));
        System.out.println("长度小于20：" + negate("Huangxianjun", str -> str.length() > 20));
        // Function
        function1("Huangxianjun", str -> str.length(), val -> val * 10);
        System.out.println("Owen's real age:" + getAgeNumber("Owen,40", str -> str.split(",")[1],
                str -> Integer.parseInt(str),
                age -> age - 1));
    }

    void function1(String value, Function<String, Integer> one, Function<Integer, Integer> two) {
        Integer rlt = one.andThen(two).apply(value);
        System.out.println("rlt:" + rlt);
    }

    int getAgeNumber(String value, Function<String, String> one, Function<String, Integer> two, Function<Integer,
            Integer> three) {
        return one.andThen(two).andThen(three).apply(value);
    }

    static boolean and(String value, Predicate<String> one, Predicate<String> two) {
        return one.and(two).test(value);
    }

    boolean or(String value, Predicate<String> one, Predicate<String> two) {
        return one.or(two).test(value);
    }

    boolean negate(String value, Predicate<String> predicate) {
        return predicate.negate().test(value);
    }

    public int getMax(Supplier<Integer> supplier) {
        return supplier.get();
    }

    private void consumeString(Consumer<String> consumer) {
        consumer.accept("Consumer");
    }

    private void consumeString(Consumer<String> consumer1, Consumer<String> consumer2) {
        consumer1.andThen(consumer2).accept("Consumer");
    }

}