package com.owen.facade;
/**
 * @Author：Owen
 * @Package：com.owen.facade
 * @Project：PatternDesign
 * @name：FacadeTests
 * @Date：2022/12/14 19:18
 * @Filename：FacadeTests
 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @since 2022/12/14 19:18
 * @author OwenHuang
 */
@Slf4j
public class FacadeTests {
    @Test
    public void test(){
        SmartAppliancesFacade facade = new SmartAppliancesFacade();
        facade.doOrder("打开");
    }
}
