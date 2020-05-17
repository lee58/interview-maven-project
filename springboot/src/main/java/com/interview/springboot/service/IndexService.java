package com.interview.springboot.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 大都督
 * @create 2020/4/3
 */
@RestController
public class IndexService {

    @RequestMapping("/")
    public Map<String, String> index() {
        HashMap<String, String> hashmap = new HashMap<>();
        hashmap.put("code", "200");
        hashmap.put("msg", "success");
        return hashmap;
    }
}
