package com.pine.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @author pine
 */
@SpringBootApplication
// 注册到eureka
@EnableEurekaClient
public class MicroOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroOrderApplication.class,args);
    }
}
