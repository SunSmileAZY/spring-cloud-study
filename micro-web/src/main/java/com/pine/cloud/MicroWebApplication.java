package com.pine.cloud;

import com.pine.cloud.service.KafkaSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author pine
 */
@SpringBootApplication
//注册到eureka
@EnableEurekaClient
//开启断路器功能
@EnableCircuitBreaker
//开启feign支持，clients指定哪个类开启feign
//@EnableFeignClients(clients = {StudentService.class,TeacherServiceFeign.class})
//开启重试功能
@EnableRetry
public class MicroWebApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(MicroWebApplication.class, args);

        sendKafka(context);
    }

    private static void sendKafka(ConfigurableApplicationContext context) {
        KafkaSender sender = context.getBean(KafkaSender.class);

        for (int i = 0; i < 10; i++) {
            //调用消息发送类中的消息发送方法
            sender.send();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Ribbon 开启用来做远程调用
     * Ribbon 就是从本地列表来进行调用
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//        factory.setConnectionRequestTimeout(2000);
//        factory.setReadTimeout(4000);
        return new RestTemplate();
    }
}
