package com.owen.bridge.bridgedesignmode;
/**
 * @Author：Owen
 * @Package：com.owen.bridge.bridgemode
 * @Project：PatternDesign
 * @name：IPayMode
 * @Date：2022/12/7 20:38
 * @Filename：IPayMode
 */

/**
 * @since 2022/12/7 20:38
 * @author OwenHuang
 */
public interface IPayMode {
    boolean validate(long userId);
}
