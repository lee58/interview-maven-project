package com.interview.springboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 大都督
 * @create 2020/4/3
 */
@ControllerAdvice //异常切面类
public class GloabalExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    @ResponseBody
    public Map<String, String> exceptionHandler() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("code", "500");
        hashMap.put("msg", "系统错误");
        return hashMap;
    }


}
