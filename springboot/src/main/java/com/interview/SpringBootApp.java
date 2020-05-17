package com.interview;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.PrintStream;

/**
 * @author 大都督
 * @create 2020/4/3
 */
@SpringBootApplication // 等同于@Configuration+@EnableAutoConfiguration+@ComponentScan
@EnableScheduling
public class SpringBootApp {
    public static void main(String[] args) {
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootApp.class);
        SpringApplication springApplication = new SpringApplication(SpringBootApp.class);
        springApplication.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                out.println(
                        "////////////////////////////////////////////////////////////////////\n" +
                        "//                          _ooOoo_                               //\n" +
                        "//                         o8888888o                              //\n" +
                        "//                         88\" . \"88                              //\n" +
                        "//                         (| ^_^ |)                              //\n" +
                        "//                         O\\  =  /O                              //\n" +
                        "//                      ____/`---'\\____                           //\n" +
                        "//                    .'  \\\\|     |//  `.                         //\n" +
                        "//                   /  \\\\|||  :  |||//  \\                        //\n" +
                        "//                  /  _||||| -:- |||||-  \\                       //\n" +
                        "//                  |   | \\\\\\  -  /// |   |                       //\n" +
                        "//                  | \\_|  ''\\---/''  |   |                       //\n" +
                        "//                  \\  .-\\__  `-`  ___/-. /                       //\n" +
                        "//                ___`. .'  /--.--\\  `. . ___                     //\n" +
                        "//              .\"\" '<  `.___\\_<|>_/___.'  >'\"\".                  //\n" +
                        "//            | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |                 //\n" +
                        "//            \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /                 //\n" +
                        "//      ========`-.____`-.___\\_____/___.-`____.-'========         //\n" +
                        "//                           `=---='                              //\n" +
                        "//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //\n" +
                        "//            佛祖保佑       永不宕机     永无BUG                  //\n" +
                        "////////////////////////////////////////////////////////////////////");
            }
        });
        springApplication.run(args);
    }
}
