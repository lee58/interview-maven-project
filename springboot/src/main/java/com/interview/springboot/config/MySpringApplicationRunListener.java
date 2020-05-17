package com.interview.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

/**
 * @author 大都督
 * @create 2020/4/4
 */
public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    private final SpringApplication application;
    private final String[] args;

    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }

    @Override
    public void starting() {
        System.out.println(">>>>starting<<<<<<<<");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        // 配置文件读取到程序中
        Properties properties = new Properties();
        try {
            // 读取自定义my.properties文件
            properties.load(this.getClass().getClassLoader().getResourceAsStream("my.properties"));
            // 读取名称为my
            PropertiesPropertySource my = new PropertiesPropertySource("my", properties);
            // 将资源添加到springboot项目中
            MutablePropertySources propertySources = environment.getPropertySources();
            propertySources.addLast(my);
        }catch (Exception e) {

        }
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
