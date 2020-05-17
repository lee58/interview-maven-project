package com.interview.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理
 * @author 大都督
 * @create 2020/5/17
 */
public class CGLibDynamicProxy {

    // 被代理的类
    static class RealService {
        public void sayHello() {
            System.out.println("hello");
        }
    }

    static class SimpleInterceptor implements MethodInterceptor {


        @Override
        public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("entering " + method.getName());
            Object result = proxy.invokeSuper(object, args);
            System.out.println("leaving " + method.getName());
            return result;
        }
    }

    // 生成代理对象
    private static <T> T getProxy(Class<T> cls) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(new SimpleInterceptor());
        return (T) enhancer.create();
    }

    public static void main(String[] args) {
        RealService proxyService = getProxy(RealService.class);
        proxyService.sayHello();
    }
}
