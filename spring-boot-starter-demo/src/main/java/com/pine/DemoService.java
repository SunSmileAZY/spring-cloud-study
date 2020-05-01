package com.pine;

import org.springframework.stereotype.Service;

/**
 * @author anzy
 * @version 1.0
 * @date 2020/4/22 16:04
 **/
@Service
public class DemoService {

    private DemoProperties demoProperties;

    public DemoProperties getDemoProperties() {
        return demoProperties;
    }

    public void setDemoProperties(DemoProperties demoProperties) {
        this.demoProperties = demoProperties;
    }

    public String demoShow(){
        return this.demoProperties.getName() + " ----- " + this.demoProperties.getContent();
    }
}