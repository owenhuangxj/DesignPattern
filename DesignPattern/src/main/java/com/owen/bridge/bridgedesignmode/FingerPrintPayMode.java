package com.owen.bridge.bridgedesignmode;
/**
 * @Author：Owen
 * @Package：com.owen.bridge.bridgemode
 * @Project：PatternDesign
 * @name：FingerPrintPayMode
 * @Date：2022/12/7 20:40
 * @Filename：FingerPrintPayMode
 */

/**
 * @author OwenHuang
 * @since 2022/12/7 20:40
 */
public class FingerPrintPayMode implements IPayMode {
    @Override
    public boolean validate(long userId) {
        System.out.println("用户：" + userId + "，指纹支付，风控校验->指纹校验成功！");
        return true;
    }
}
