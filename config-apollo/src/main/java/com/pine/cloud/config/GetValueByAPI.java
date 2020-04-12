package com.pine.cloud.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author anzy
 * @version 1.0
 * @date 2020/4/10 16:48
 **/
@Component
public class GetValueByAPI {

    @Autowired
    private ConfigJavaBean configJavaBean;
    @PostConstruct
    public void getValue(){
        Config config = ConfigService.getAppConfig();
        String key = "str1";
        String defaultValue = "apollo_client";
        String value = config.getProperty(key,defaultValue);
        System.out.println(String.format("value is %s",value));
        System.out.println("================" + configJavaBean.getOneKey());
        System.out.println("================" + configJavaBean.getTwoKey());
    }


}
