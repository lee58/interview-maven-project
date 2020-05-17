package com.interview.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author 大都督
 * @create 2020/3/24
 */
@Component
public class Consumer {

    @JmsListener(destination = "${queue}")
    public void receive(String msg) {
        System.out.println("监听器收到msg:" + msg);
    }

}

