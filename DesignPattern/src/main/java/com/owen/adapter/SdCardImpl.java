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
public class SdCardImpl implements SdCard {
    @Override
    public String readFromSd() {
        System.out.println("Reading SD card.");
        return "SD Card content.";
    }

    @Override
    public void writeToSd(String data) {
        System.out.println("Write to SD card:" + data);
    }
}
