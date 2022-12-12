package com.owen.adapter.object;
/**
 * @Author：Owen
 * @Package：com.owen.adapter.object
 * @Project：PatternDesign
 * @name：SdCard2TfCardAdapter
 * @Date：2022/12/9 21:31
 * @Filename：SdCard2TfCardAdapter
 */

import com.owen.adapter.SdCard;
import com.owen.adapter.TfCard;

/**
 * SD card适配TF card的适配器需要持有TFCard类的引用
 * @author OwenHuang
 * @since 2022/12/9 21:31
 */
public class SdCard2TfCardAdapter implements SdCard {
    private TfCard tfCard;

    public SdCard2TfCardAdapter(TfCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readFromSd() {
        return tfCard.readFromTf();
    }

    @Override
    public void writeToSd(String data) {
        tfCard.writeToTf(data);
    }
}
