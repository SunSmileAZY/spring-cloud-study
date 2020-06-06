package com.pine.cloud.service;

import com.alibaba.fastjson.JSONObject;
import com.pine.cloud.bean.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author anzy
 * @version 1.0
 * @date 2020/6/6 12:50
 **/
@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 发送消息方法
     */
    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("+++++++++++++++++++++  message = {}", JSONObject.toJSONString(message));
        kafkaTemplate.send("pine", JSONObject.toJSONString(message));
    }
}
