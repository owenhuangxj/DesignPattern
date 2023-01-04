package com.owen.strategy.mashibing;
/**
 * @Author：Owen
 * @Package：com.owen.strategy
 * @Project：PatternDesign
 * @name：Dot
 * @Date：2022/11/29 21:43
 * @Filename：Dot
 */

/**
 * @author OwenHuang
 * @since 2022/11/29 21:43
 */
public class Dog implements Comparator<Dog> {
    int length;

    public int getLength() {
        return length;
    }

    public Dog(int length) {
        this.length = length;
    }

    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.length - o2.length;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "length=" + length +
                '}';
    }
}
