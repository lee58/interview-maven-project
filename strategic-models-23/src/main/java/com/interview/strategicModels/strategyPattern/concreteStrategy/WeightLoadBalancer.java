package com.interview.strategicModels.strategyPattern.concreteStrategy;

import com.interview.strategicModels.strategyPattern.entity.WeightEntity;
import com.interview.strategicModels.strategyPattern.strategy.LoadBalancerStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 大都督
 * @create 2020/4/7
 */
public class WeightLoadBalancer extends LoadBalancerStrategy {

    private List<String> addressList = new ArrayList<String>();

    @Override
    public String getSingleAddress(List weightEntityList) {
        if (weightEntityList.size() > 0) {
            // 对权重数据实现重新排序
            for (int i = 0; i < weightEntityList.size(); i++) {
                WeightEntity weightEntity = (WeightEntity) weightEntityList.get(i);
                int weight = weightEntity.getWeight();
                for (int j = 0; j < weight; j++) {
                    addressList.add(weightEntity.getAddress());
                }
            }
        }
        return getOneAddress(addressList);
    }



}
