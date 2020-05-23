package com.interview.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 大都督
 * @create 2020/5/23
 */
public class JdkInvocationHandler implements InvocationHandler {

    // 目标对象（被代理类）
    private Object target;

    public JdkInvocationHandler(Object target) {
        this.target = target;
    }
    /**
     * 使用生成的代理类拦截回调
     * @param proxy jdk动态生成的代理类
     * @param method 不是真正的目标方法，接口中的方法，底层通过反射执行真正的目标方法
     * @param args 代理类的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理执行开始 args=" + args[0]);
        // 调用目标方法，Java反射执行目标方法
        Object result = method.invoke(target, args);
        System.out.println("jdk动态代理执行结束" + args[0]);
        return result;
    }

    /**
     * 使用jdk生成代理类对象
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        // ClassLoader 读取代理类的class文件
        // interfaces 基于该接口拼接代理类的源代码
        // invocationHandler this
        Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return (T) o;
    }

    public <T> T getProxy2() {
        return (T) new $Proxy0(this);
    }
}
