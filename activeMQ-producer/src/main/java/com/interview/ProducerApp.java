package com.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 大都督
 * @create 2020/3/24
 */
@SpringBootApplication
@EnableScheduling
public class ProducerApp {
        public static void main(String[] args) {
            SpringApplication.run(ProducerApp.class, args);
        }
    }
