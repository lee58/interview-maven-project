package com.interview.mybatis.controller;

import com.interview.mybatis.mapper.UserMapper;
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
    private UserMapper userMapper;

    @RequestMapping("/addUser")
    public Integer addUser(String userName, Integer age) {
        return userMapper.insert(userName, age);
    }
}
