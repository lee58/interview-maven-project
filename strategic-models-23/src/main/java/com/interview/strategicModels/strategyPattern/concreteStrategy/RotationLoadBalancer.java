package com.interview.strategicModels.strategyPattern.concreteStrategy;

import com.interview.strategicModels.strategyPattern.strategy.LoadBalancerStrategy;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 大都督
 * @create 2020/4/7
 */
public class RotationLoadBalancer extends LoadBalancerStrategy {


    @Override
    public String getSingleAddress(List address) {

        return getOneAddress(address);
    }



    /**
     * 轮训机制 算法1
     *
     * @param addres
     * @return
     */
//    public synchronized String getSingleAddres(List<String> addres) {
//        if (index >= addres.size()) {
//            index = 0;
//        }
//        String ads = addres.get(index++);
//        System.out.println("ads:" + ads);
//        return ads;
//    }
}
