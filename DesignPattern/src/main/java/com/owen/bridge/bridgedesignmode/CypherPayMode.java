package com.owen.bridge.bridgedesignmode;
/**
 * @Author：Owen
 * @Package：com.owen.bridge.bridgemode
 * @Project：PatternDesign
 * @name：CypherPayMode
 * @Date：2022/12/7 20:40
 * @Filename：CypherPayMode
 */

/**
 * @author OwenHuang
 * @since 2022/12/7 20:40
 */
public class CypherPayMode implements IPayMode {
    @Override
    public boolean validate(long userId) {
        System.out.println("用户：" + userId + "，进行密码支付，风控校验->密码校验成功！");
        return true;
    }
}