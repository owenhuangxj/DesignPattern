package com.owen.prototype.clone;
/**
 * @Author：Owen
 * @Package：com.owen.prototype.clone
 * @Project：PatternDesign
 * @name：Adresses
 * @Date：2022/12/4 13:15
 * @Filename：Adresses
 */

import java.io.Serializable;

/**
 * @author OwenHuang
 * @since 2022/12/4 13:15
 */
public class Address implements Serializable {
    private String nation;

    private String province;

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "nation='" + nation + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
