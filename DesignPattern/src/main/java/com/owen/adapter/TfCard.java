package com.owen.adapter;
/**
 * @Author：Owen
 * @Package：com.owen.adapter.clz
 * @Project：PatternDesign
 * @name：SDCard
 * @Date：2022/12/9 21:19
 * @Filename：SDCard
 */

/**
 * @since 2022/12/9 21:19
 * @author OwenHuang
 */
public interface TfCard {
    String readFromTf();
    void writeToTf(String data);
}
