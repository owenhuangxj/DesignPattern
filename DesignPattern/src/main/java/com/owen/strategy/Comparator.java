package com.owen.strategy;
/**
 * @Author：Owen
 * @Package：com.owen.strategy
 * @Project：PatternDesign
 * @name：Comparator
 * @Date：2022/11/29 21:40
 * @Filename：Comparator
 */

/**
 * @author OwenHuang
 * @since 2022/11/29 21:40
 */
public interface Comparator<T> {
    int compare(T o1, T o2);
}
