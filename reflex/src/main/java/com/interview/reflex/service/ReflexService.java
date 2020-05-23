package com.interview.reflex.service;


/**
 * @author 大都督
 * @create 2020/5/22
 */
public interface ReflexService {
    public void printClass();
    public void printClassName(String className, Class<? > cls);

    void printFieldInfo(Class<?> cls);
}
