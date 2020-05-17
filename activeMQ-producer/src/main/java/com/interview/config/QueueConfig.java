package com.interview.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @author 大都督
 * @create 2020/3/24
 */
@Configuration
public class QueueConfig {

    @Value("${queue}")
    private String queue;

    @Bean
    public Queue logQueue() {
        return new ActiveMQQueue(queue);
    }
}
