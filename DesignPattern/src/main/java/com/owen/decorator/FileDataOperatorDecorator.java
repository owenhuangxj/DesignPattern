package com.owen.decorator;
/**
 * @Author：Owen
 * @Package：com.owen.decorator
 * @Project：PatternDesign
 * @name：FileDataOperatorDecorator
 * @Date：2022/12/7 21:47
 * @Filename：FileDataOperatorDecorator
 */

/**
 * 文件装饰器抽象父类
 *
 * @author OwenHuang
 * @since 2022/12/7 21:47
 */
public abstract class FileDataOperatorDecorator implements FileDataOperator {
    private FileDataOperator fileDataOperator;

    public FileDataOperatorDecorator(FileDataOperator fileDataOperator) {
        this.fileDataOperator = fileDataOperator;
    }

    @Override
    public String read() {
        return fileDataOperator.read();
    }

    @Override
    public void write(String data) {
        fileDataOperator.write(data);
    }
}
