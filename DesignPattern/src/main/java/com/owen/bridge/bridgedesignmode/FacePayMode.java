package com.owen.bridge.bridgedesignmode;
/**
 * @Author：Owen
 * @Package：com.owen.bridge.bridgemode
 * @Project：PatternDesign
 * @name：FacePayMode
 * @Date：2022/12/7 20:39
 * @Filename：FacePayMode
 */

/**
 * @author OwenHuang
 * @since 2022/12/7 20:39
 */
public class FacePayMode implements IPayMode {
    @Override
    public boolean validate(long userId) {
        System.out.println("用户：" + userId + "，进行人脸支付，风控校验->人脸校验成功！");
        return true;
    }
}
