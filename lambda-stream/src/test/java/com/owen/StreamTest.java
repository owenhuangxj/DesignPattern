package com.owen;
/**
 * @Author：Owen
 * @Package：com.owen
 * @Project：lambda-stream
 * @name：StreamTest
 * @Date：2023/1/1 20:36
 * @Filename：StreamTest
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author OwenHuang
 * @since 2023/1/1 20:36
 */
public class StreamTest {
    @Test
    public void firstExperience() {
        String rlt =
                List.of("张无忌", "赵敏", "张三丰", "周芷若", "李强").stream()
                        .filter(str -> str.startsWith("张"))
                        .filter(str -> str.length() == 3)
                        .limit(1)
                        .findFirst()
                        .orElse("Nothing");
        Assertions.assertEquals(rlt, "张无忌");
    }

    @Test
    public void testStreamMap1() {
        List<User> list = new ArrayList<>();
        Collections.addAll(list, new User(1, "Owen", 40), new User(2, "曾强", 30), new User(3, "王平", 35));
        List<String> rlt = list.stream().map(User::getName).collect(Collectors.toList());
        Assertions.assertEquals(rlt.get(0), "Owen");
    }

    @Test
    public void testStreamMap2() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Owen,40", "王平,37", "增强,30", "黄显军,39");
        List<String> rlt =
                list.stream().map(str -> str.split(",")[0]).collect(Collectors.toList()).stream().filter(str -> str.length() >= 3).collect(Collectors.toList());
        Assertions.assertTrue(rlt.size() == 2);
    }
}
