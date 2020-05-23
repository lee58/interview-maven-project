package com.interview.proxy.service.impl;

import com.interview.proxy.service.OrderService;

/**
 * @author 大都督
 * @create 2020/5/23
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public String addOrder(String orderId, String orderName) {
        System.out.println("OrderServiceImpl日志打印：" + orderId + ", " + orderName);
        return orderId + "," + orderName;
    }
}
