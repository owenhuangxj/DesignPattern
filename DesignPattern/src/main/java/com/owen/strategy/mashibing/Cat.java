package com.owen.strategy.mashibing;
/**
 * @Author：Owen
 * @Package：com.owen.strategy
 * @Project：PatternDesign
 * @name：Cat
 * @Date：2022/11/29 21:42
 * @Filename：Cat
 */

/**
 * @author OwenHuang
 * @since 2022/11/29 21:42
 */
public class Cat implements Comparator<Cat> {
    int age;
    int weight;

    public Cat(int age, int weight) {
        this.age = age;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.age - o2.age == 0 ? o1.weight - o2.weight : o1.age - o2.age;
    }
}
