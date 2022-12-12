package com.owen.adapter;
/**
 * @Author：Owen
 * @Package：com.owen.adapter.clz
 * @Project：PatternDesign
 * @name：Computer
 * @Date：2022/12/9 21:25
 * @Filename：Computer
 */

/**
 * @since 2022/12/9 21:25
 * @author OwenHuang
 */
public class Computer {
    public String read(SdCard sdCard){
        return sdCard.readFromSd();
    }
}
