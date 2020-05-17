package com.interview.springboot.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大都督
 * @create 2020/4/3
 */
@RestController //作用：表示当前类所有方法返回json 原理：@Controller @ResponseBody
@EnableAutoConfiguration // 作用：启动springMVC 默认扫包范围是当前类
@ComponentScan("com.interview.springboot.service") // 设置扫包范围
public class HelloService {

    @RequestMapping("/hello")
    public String hello() {
        return "学习springboot";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloService.class);
    }
}
