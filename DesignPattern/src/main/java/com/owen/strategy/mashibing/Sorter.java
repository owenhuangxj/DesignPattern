package com.owen.strategy.mashibing;
/**
 * @Author：Owen
 * @Package：com.owen.strategy
 * @Project：PatternDesign
 * @name：Sortor
 * @Date：2022/11/29 21:46
 * @Filename：Sortor
 */

/**
 * @author OwenHuang
 * @since 2022/11/29 21:46
 */
public class Sorter<T> {

    void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                /* 找到最小元素下标 */
                minPos = comparator.compare(arr[j], arr[minPos]) <= -1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }
}