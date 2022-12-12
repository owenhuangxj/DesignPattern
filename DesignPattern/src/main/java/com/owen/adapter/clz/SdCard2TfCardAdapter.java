package com.owen.adapter.clz;
/**
 * @Author：Owen
 * @Package：com.owen.adapter.clz
 * @Project：PatternDesign
 * @name：SdCardAdapterTfCard
 * @Date：2022/12/9 21:28
 * @Filename：SdCardAdapterTfCard
 */

import com.owen.adapter.SdCard;
import com.owen.adapter.TfCardImpl;

/**
 * @author OwenHuang
 * @since 2022/12/9 21:28
 */
public class SdCard2TfCardAdapter extends TfCardImpl implements SdCard {
    @Override
    public String readFromSd() {
        return readFromTf();
    }

    @Override
    public void writeToSd(String data) {
        writeToTf(data);
    }
}
