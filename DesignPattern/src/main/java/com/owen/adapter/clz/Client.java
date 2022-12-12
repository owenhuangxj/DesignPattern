package com.owen.adapter.clz;
/**
 * @Author：Owen
 * @Package：com.owen.adapter.clz
 * @Project：PatternDesign
 * @name：Client
 * @Date：2022/12/9 21:26
 * @Filename：Client
 */

import com.owen.adapter.Computer;
import com.owen.adapter.SdCard;
import com.owen.adapter.SdCardImpl;

/**
 * @since 2022/12/9 21:26
 * @author OwenHuang
 */
public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        SdCard sdCard = new SdCardImpl();
        System.out.println(computer.read(sdCard));
    }
}
