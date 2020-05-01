package com.pine.cloud.controller;

import com.pine.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anzy
 * @version 1.0
 * @date 2020/4/22 16:07
 **/
@RestController
@RequestMapping("/demo/")
public class DemoStarterController {
    @Autowired
    private DemoService demoService;

    @GetMapping("demo")
    public String demo(){
        return demoService.demoShow();
    }
}
