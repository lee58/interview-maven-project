package com.interview.proxy;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 静态代理
 * @author 大都督
 * @create 2020/5/17
 */
public class StaticProxy {

    // 代理和实际对象共同的接口
    static interface IService{
        public void sayHello();
    }

    // 实际对象
    static class RealService implements IService{

        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }

    // 代理
    static class TraceProxy implements IService{
        private IService realService;
        public TraceProxy(IService realService) {
            this.realService = realService;
        }
        @Override
        public void sayHello() {
            System.out.println("entering sayHello");
            this.realService.sayHello();
            System.out.println("leaving sayHello");
        }
    }

    public static void main(String[] args) {
        IService realService = new RealService();
        IService proxyService = new TraceProxy(realService);
        proxyService.sayHello();
    }
}
