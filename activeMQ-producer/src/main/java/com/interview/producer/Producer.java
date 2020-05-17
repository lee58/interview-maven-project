package com.interview.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @author 大都督
 * @create 2020/3/24
 */
@Component
@EnableScheduling
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 5000)
    public void send() {
        jmsMessagingTemplate.convertAndSend(queue, "测试消息队列" + System.currentTimeMillis());
    }
}
