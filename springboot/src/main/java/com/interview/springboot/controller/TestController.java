package com.interview.springboot.controller;

import com.ligg.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大都督
 * @create 2020/4/3
 */
@RestController
public class TestController {

    @Autowired
    private TokenService tokenService;
    @Value("${ligg.name}")
    private String name;
    @Value("${my.name}")
    private String myName;

    @RequestMapping("/getMyName")
    public String getgetMyName() {
        return myName;
    }


    @RequestMapping("/getLiggToken")
    public String getLiggToken() {
        return tokenService.getToken();
    }

    @RequestMapping("/getYmlName")
    public String getYmlName() {
        return name;
    }

    @RequestMapping("/testException")
    public String testException(Integer i) {
        int num = 1/i;
        return "success";
    }
}
