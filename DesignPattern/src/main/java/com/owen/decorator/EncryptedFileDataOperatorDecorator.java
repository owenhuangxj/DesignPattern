package com.owen.decorator;
/**
 * @Author：Owen
 * @Package：com.owen.decorator
 * @Project：PatternDesign
 * @name：EncryptionFileDataOperatorDecorator
 * @Date：2022/12/7 21:49
 * @Filename：EncryptionFileDataOperatorDecorator
 */

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author OwenHuang
 * @since 2022/12/7 21:49
 */
public class EncryptedFileDataOperatorDecorator extends FileDataOperatorDecorator {
    public EncryptedFileDataOperatorDecorator(FileDataOperator fileDataOperator) {
        super(fileDataOperator);
    }

    private String decrypt(String data) {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(data), StandardCharsets.UTF_8);
    }

    @Override
    public String read() {
        return decrypt(super.read());
    }

    private String encrypt(String data) {
        if (data == null || data.isEmpty()) {
            return "";
        }
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(data.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void write(String data) {
        super.write(encrypt(data));
    }
}
