package com.interview.strategicModels.strategyPattern;

import com.interview.strategicModels.strategyPattern.concreteStrategy.IpHashLoadBalancer;
import com.interview.strategicModels.strategyPattern.concreteStrategy.WeightLoadBalancer;
import com.interview.strategicModels.strategyPattern.context.ContextClient;
import com.interview.strategicModels.strategyPattern.entity.WeightEntity;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 大都督
 * @create 2020/4/7
 */
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        RotationLoadBalancer rotationLoadBalancer = new RotationLoadBalancer();
//        WeightLoadBalancer weightLoadBalancer = new WeightLoadBalancer();
//        ContextClient contextClient = new ContextClient(weightLoadBalancer);
        list.add("127.0.0.1:8080");
        list.add("127.0.0.1:8081");
//        list.add(new WeightEntity("127.0.0.1:8080", 1));
//        list.add(new WeightEntity("127.0.0.1:8081", 2));
//        contextClient.getSingleAddress(list);
//        contextClient.getSingleAddress(list);
//        contextClient.getSingleAddress(list);
//        contextClient.getSingleAddress(list);
//        contextClient.getSingleAddress(list);
        IpHashLoadBalancer ipHashLoadBalancer = new IpHashLoadBalancer();
        ipHashLoadBalancer.getSingleAddress(list, "127.0.0.1");
        ipHashLoadBalancer.getSingleAddress(list, "127.0.0.1");
        ipHashLoadBalancer.getSingleAddress(list, "127.0.0.1");
        ipHashLoadBalancer.getSingleAddress(list, "127.0.0.1");
        ipHashLoadBalancer.getSingleAddress(list, "127.0.0.1");
    }
}
