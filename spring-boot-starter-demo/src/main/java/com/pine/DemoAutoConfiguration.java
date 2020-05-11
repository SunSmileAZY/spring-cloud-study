package com.pine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author anzy
 * @version 1.0
 * @date 2020/4/22 16:04
 **/
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(DemoProperties.class)
public class DemoAutoConfiguration {

    @Autowired
    private DemoProperties demoProperties;

    @Bean
    public DemoService demoService(){
        DemoService demoService = new DemoService();
        demoService.setDemoProperties(demoProperties);
        return demoService;
    }
}