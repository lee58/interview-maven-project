package com.interview.strategicModels.strategyPattern.context;

import com.interview.strategicModels.strategyPattern.strategy.LoadBalancerStrategy;
import sun.security.x509.IPAddressName;

import java.util.List;

/**
 * @author 大都督
 * @create 2020/4/7
 */
public class ContextClient {
    private LoadBalancerStrategy loadBalancerStrategy;

    public ContextClient(LoadBalancerStrategy loadBalancerStrategy) {
        this.loadBalancerStrategy = loadBalancerStrategy;
    }

    public String getSingleAddress(List list) {
        return loadBalancerStrategy.getSingleAddress(list);
    }

}
