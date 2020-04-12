package com.pine.cloud.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author anzy
 * @version 1.0
 * @date 2020/4/10 16:49
 **/
@Configuration
@EnableApolloConfig(value = "dev",order = 1)
public class JavaConfig {

    @Bean
    public ConfigJavaBean configJavaBean(){
        ConfigJavaBean configJavaBean =  new ConfigJavaBean();
        return configJavaBean;
    }
}