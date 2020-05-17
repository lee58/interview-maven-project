package com.interview.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大都督
 * @create 2020/4/3
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "indexController success";
    }

}
