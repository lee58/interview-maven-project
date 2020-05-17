package com.interview.docker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大都督
 * @create 2020/4/2
 */
@RestController
public class TestController {

    @RequestMapping("/docker")
    public String docker() {
        return "this is docker";
    }
}
