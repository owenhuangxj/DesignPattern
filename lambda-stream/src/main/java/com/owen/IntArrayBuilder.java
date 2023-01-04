package com.owen;
/**
 * @Author：Owen
 * @Package：com.owen
 * @Project：lambda-stream
 * @name：ArrayBuilder
 * @Date：2023/1/1 20:24
 * @Filename：ArrayBuilder
 */

/**
 * @author OwenHuang
 * @since 2023/1/1 20:24
 */
@FunctionalInterface
public interface IntArrayBuilder {
    int[] build(int length);
}
