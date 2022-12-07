package com.owen.decorator;
/**
 * @Author：Owen
 * @Package：com.owen.decorator
 * @Project：PatternDesign
 * @name：FileDataOperator
 * @Date：2022/12/7 21:39
 * @Filename：FileDataOperator
 */

/**
 * @author OwenHuang
 * @since 2022/12/7 21:39
 */
public interface FileDataOperator {
    String read();

    void write(String data);
}
