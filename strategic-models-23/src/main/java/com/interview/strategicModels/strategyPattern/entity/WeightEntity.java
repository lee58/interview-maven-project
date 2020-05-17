package com.interview.strategicModels.strategyPattern.entity;

/**
 * @author 大都督
 * @create 2020/4/7
 */
public class WeightEntity {

    private String address;

    private int weight;

    public WeightEntity(String address, int weight) {
        this.address = address;
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
