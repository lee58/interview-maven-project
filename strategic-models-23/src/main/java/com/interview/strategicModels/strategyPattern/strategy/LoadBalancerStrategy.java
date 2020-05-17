package com.interview.strategicModels.strategyPattern.strategy;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 大都督
 * @create 2020/4/7
 */
public abstract class LoadBalancerStrategy {

    private int index;
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    /**
     * 根据多个地址实现负载均衡轮训、权重、随机、一致性hash
     *
     * @param address
     * @return
     */
    public abstract String getSingleAddress(List address);

    public String getOneAddress(List<String> address) {
        Integer index = atomicInteger.incrementAndGet() % address.size();
        String ads = (String) address.get(index);
        System.out.println("ads:" + ads);
        return ads;
    }


}
