package com.pine.cloud.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author anzy
 * @version 1.0
 * @date 2020/4/10 16:51
 **/
public class ConfigJavaBean {

    @Value("${str1:defaultValue}")
    private String oneKey;

    @Value("${str2:22}")
    private String twoKey;

    public String getOneKey() {
        return oneKey;
    }

    public void setOneKey(String oneKey) {
        this.oneKey = oneKey;
    }

    public String getTwoKey() {
        return twoKey;
    }

    public void setTwoKey(String twoKey) {
        this.twoKey = twoKey;
    }
}
