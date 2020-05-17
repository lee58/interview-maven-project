package com.interview.ehcache.controller;

import com.interview.ehcache.entity.User;
import com.interview.ehcache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大都督
 * @create 2020/3/26
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CacheManager cacheManager;

    @RequestMapping("/getUserByName")
    public String getUserByName(String name) {
        User ligg = userMapper.findByName(name);
        return ligg.getId().toString();
    }

    @RequestMapping("/removeValue")
    public String removeValue() {
        cacheManager.getCache("baseCache").clear();
        return "success";
    }
}
