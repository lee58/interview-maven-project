package com.interview.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大都督
 * @create 2020/3/27
 */
@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/setString")
    public String setString(String key , String value) {
        redisService.setObject(key, value);
        return "success";
    }
    @RequestMapping("/getString")
    public String getString(String key) {
        return redisService.getString(key);
    }
}
