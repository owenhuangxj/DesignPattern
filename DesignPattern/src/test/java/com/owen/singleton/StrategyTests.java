package com.owen.singleton;
/**
 * @Author：Owen
 * @Package：com.owen.singleton
 * @Project：PatternDesign
 * @name：StrategyTests
 * @Date：2022/11/29 21:52
 * @Filename：StrategyTests
 */

import com.owen.strategy.mashibing.Dog;
import com.owen.strategy.mashibing.Sorter;
import org.junit.jupiter.api.Test;

/**
 * @author OwenHuang
 * @since 2022/11/29 21:52
 */
public class StrategyTests {
    @Test
    public void test() {
        Dog[] dogs = {new Dog(1), new Dog(5), new Dog(3), new Dog(15)};
        new Sorter<Dog>().sort(dogs,
                (o1, o2) -> o1.getLength() - o2.getLength());
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
    }
}
