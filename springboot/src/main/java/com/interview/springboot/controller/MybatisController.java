package com.interview.springboot.controller;

import com.interview.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大都督
 * @create 2020/4/3
 */
@RestController
public class MybatisController {
    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public Integer addUser(String userName, String age) {
        return userService.addUser(userName, age);
    }
}
