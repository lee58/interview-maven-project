package com.interview.proxy;

import com.interview.proxy.jdk.JdkInvocationHandler;
import com.interview.proxy.service.OrderService;
import com.interview.proxy.service.impl.OrderServiceImpl;
import com.interview.proxy.staticProxy.OrderServiceProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 大都督
 * @create 2020/5/23
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProxyTest {

    @Test
    public void testProxy() {
//        methodStaticProxy();
        methodJdk();
    }

    private void methodJdk() {
        JdkInvocationHandler jdkInvocationHandler = new JdkInvocationHandler(new OrderServiceImpl());
        // 查看jdk动态生成的代理类代码
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        OrderService proxy = jdkInvocationHandler.getProxy2();
        String liguogang = proxy.addOrder("liguogang", "666");
        System.out.println(liguogang);

    }

    private void methodStaticProxy() {
        OrderServiceProxy orderServiceProxy = new OrderServiceProxy(new OrderServiceImpl());
        orderServiceProxy.addOrder("liguogang", "666");
    }
}
