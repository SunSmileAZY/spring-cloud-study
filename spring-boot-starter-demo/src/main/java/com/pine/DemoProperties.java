package com.pine;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author anzy
 * @version 1.0
 * @date 2020/4/22 16:01
 **/
@ConfigurationProperties(prefix = "pine.demo")
public class DemoProperties {
    private String name;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
