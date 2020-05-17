package com.interview.proxy;

import java.lang.reflect.*;

/**
 * Java SDK实现动态代理
 * @author 大都督
 * @create 2020/5/17
 */
public class JDKDynamicProxy {

    static interface IService {
        public void sayHello();
    }

    static class RealService implements IService {

        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }

    static class SimpleInvocationHandler implements InvocationHandler{
        // 被代理的对象
        private Object realObj;
        public SimpleInvocationHandler(Object realObj) {
            this.realObj = realObj;
        }

        /**
         * 处理所有接口的调用
          * @param proxy 代理对象本身
         * @param method 正在被调用的方法
         * @param args 方法的参数
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("entering " + method.getName());
            Object result = method.invoke(realObj, args);
            System.out.println("leaving " + method.getName());
            return result;
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        IService realService = new RealService();
        // 创建代理对象
//        IService proxyService = (IService) Proxy.newProxyInstance(
//                IService.class.getClassLoader(),
//                new Class<? >[] {IService.class},
//                new SimpleInvocationHandler(realService)
//        );
        // 通过Proxy.getProxyClass创建代理类定义，类定义会被缓存；
        Class<?> proxyCls = Proxy.getProxyClass(IService.class.getClassLoader(), new Class<?>[]{IService.class});
        // 获取代理类的构造方法，构造方法有一个InvocationHandler类型的参数；
        Constructor<?> ctor = proxyCls.getConstructor(new Class<?>[]{InvocationHandler.class});
        // 创建InvocationHandler对象，创建代理类对象。
        InvocationHandler handler = new SimpleInvocationHandler((realService));
        IService proxyService = (IService)ctor.newInstance(handler);
        proxyService.sayHello();
    }
}
