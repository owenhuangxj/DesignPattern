package com.owen.decorator;
/**
 * @Author：Owen
 * @Package：com.owen.decorator
 * @Project：PatternDesign
 * @name：DecoratorTests
 * @Date：2022/12/7 22:01
 * @Filename：DecoratorTests
 */

import org.junit.jupiter.api.Test;

/**
 * @author OwenHuang
 * @since 2022/12/7 22:01
 */
public class DecoratorTests {
    private String filepath = "base-file.txt";
    private String data = "name:Owen,age:40";

    @Test
    public void testBaseFileDataWrite() {
        new BaseFileDataOperator(filepath).write("name:Owen,age:40");
    }

    @Test
    public void testWriteEncryptedData() {
        new EncryptedFileDataOperatorDecorator(new BaseFileDataOperator(filepath)).write(data);
    }

    @Test
    public void testReadEncryptedData() {
        String decryptedData = new EncryptedFileDataOperatorDecorator(new BaseFileDataOperator(filepath)).read();
        System.out.println("data：" + decryptedData);
    }
}
