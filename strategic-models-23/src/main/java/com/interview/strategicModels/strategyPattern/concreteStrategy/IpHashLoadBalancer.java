package com.interview.strategicModels.strategyPattern.concreteStrategy;

import com.interview.strategicModels.strategyPattern.entity.WeightEntity;
import com.interview.strategicModels.strategyPattern.strategy.LoadBalancerStrategy;
import sun.security.x509.IPAddressName;

import java.util.List;

public class IpHashLoadBalancer {

    public String getSingleAddress(List<String> address, String ipAddress) {
        int index = ipAddress.hashCode() % address.size();
        String value = address.get(index);
        System.out.println("value:" + value);
        return value;
    }
}