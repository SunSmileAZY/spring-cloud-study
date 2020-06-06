package com.pine.cloud.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author anzy
 * @version 1.0
 * @date 2020/6/6 12:46
 **/
@Data
public class Message {

    private Long id;

    private String msg;

    private Date sendTime;
}
