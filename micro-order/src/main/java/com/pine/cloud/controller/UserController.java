package com.pine.cloud.controller;

import com.pine.cloud.bean.ConsultContent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author anzy
 * @version 1.0
 * @date 2020/3/19 14:06
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    ///user/queryContent
    @RequestMapping("/queryContent")
    public List<String> queryContent(String a) {
        log.info("调用 queryContent 服务, {}", a);
        List<String> list = new ArrayList<>();
        list.add("模拟请求结果：result1");
        list.add("模拟请求结果：result2");
        list.add("模拟请求结果：result3");
        return list;
    }


}
