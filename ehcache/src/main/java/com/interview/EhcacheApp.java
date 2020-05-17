package com.interview;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author 大都督
 * @create 2020/3/26
 */
@SpringBootApplication
@EnableCaching // 开启缓存注解
@EnableAsync
public class EhcacheApp {
    public static void main(String[] args) {
        SpringApplication.run(EhcacheApp.class);
    }
}
