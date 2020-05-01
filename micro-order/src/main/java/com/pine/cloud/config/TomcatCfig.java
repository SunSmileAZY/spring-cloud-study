package com.pine.cloud.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * @author anzy
 * @version 1.0
 * @date 2020/4/22 16:36
 **/
@Component
public class TomcatCfig implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
    @Override
    public void customize(TomcatServletWebServerFactory factory) {

        factory.setContextPath("/demo");
        factory.setPort(8090);
        factory.setProtocol("NIO");
    }
}