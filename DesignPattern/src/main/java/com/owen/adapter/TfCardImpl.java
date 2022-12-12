package com.owen.adapter;
/**
 * @Author：Owen
 * @Package：com.owen.adapter.clz
 * @Project：PatternDesign
 * @name：SdCardImpl
 * @Date：2022/12/9 21:21
 * @Filename：SdCardImpl
 */

/**
 * @author OwenHuang
 * @since 2022/12/9 21:21
 */
public class TfCardImpl implements TfCard {
    @Override
    public String readFromTf() {
        System.out.println("Reading TF card.");
        return "TF Card content.";
    }

    @Override
    public void writeToTf(String data) {
        System.out.println("Write to TF card:" + data);
    }
}
