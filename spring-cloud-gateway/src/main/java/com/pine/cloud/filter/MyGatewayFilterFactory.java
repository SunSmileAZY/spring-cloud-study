package com.pine.cloud.filter;

import lombok.Data;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

import java.util.List;

/**
 * @author anzy
 * @version 1.0
 * @date 2020/5/11 15:44
 **/
public class MyGatewayFilterFactory extends AbstractGatewayFilterFactory<MyGatewayFilterFactory.Config> {

    public MyGatewayFilterFactory(){
        super(Config.class);
    }

    /**
     * 权限验证
     * @param config
     * @return
     */
    @Override
    public GatewayFilter apply(Config config) {
        return null;
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return null;
    }

    @Data
    public static class Config{

        private boolean enable;

    }



}
