package com.owen;
/**
 * @Author：Owen
 * @Package：com.owen
 * @Project：lambda-stream
 * @name：Factory
 * @Date：2022/12/31 19:54
 * @Filename：Factory
 */

/**
 * @author OwenHuang
 * @since 2022/12/31 19:54
 */
@FunctionalInterface
public interface BeanFactory {
    Object getObject();
}
