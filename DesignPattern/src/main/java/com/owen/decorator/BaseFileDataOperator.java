package com.owen.decorator;
/**
 * @Author：Owen
 * @Package：com.owen.decorator
 * @Project：PatternDesign
 * @name：BaseFileDataOperator
 * @Date：2022/12/7 21:42
 * @Filename：BaseFileDataOperator
 */

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 基础数据操作类
 *
 * @author OwenHuang
 * @since 2022/12/7 21:42
 */
public class BaseFileDataOperator implements FileDataOperator {
    private String filepath;

    public BaseFileDataOperator(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public String read() {
        try {
            return FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void write(String data) {
        try {
            FileUtils.writeStringToFile(new File(filepath), data, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
