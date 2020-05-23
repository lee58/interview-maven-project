package com.interview.proxy.staticProxy;

import com.interview.proxy.service.OrderService;

/**
 * @author 大都督
 * @create 2020/5/23
 */
public class OrderServiceProxy implements OrderService {
    // 被代理类
    private OrderService orderService;

    public OrderServiceProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String addOrder(String orderId, String orderName) {
        System.out.println("代理日志打印：" + orderId + ", " + orderName);
        return orderService.addOrder(orderId, orderName);
    }
}
