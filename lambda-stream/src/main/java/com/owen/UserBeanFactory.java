package com.owen;
/**
 * @Author：Owen
 * @Package：com.owen
 * @Project：lambda-stream
 * @name：UserBeanFactory
 * @Date：2022/12/31 20:05
 * @Filename：UserBeanFactory
 */

/**
 * @since 2022/12/31 20:05
 * @author OwenHuang
 */
public class UserBeanFactory implements BeanFactory{
    @Override
    public Object getObject() {
        return new User(1,"Owen",40);
    }
}
