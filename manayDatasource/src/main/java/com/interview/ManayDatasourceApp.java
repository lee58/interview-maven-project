package com.interview;

import com.interview.config.interview.InterviewConfig;
import com.interview.config.interviewMaven.InterviewMavenConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author 大都督
 * @create 2020/4/3
 */
@SpringBootApplication
@EnableConfigurationProperties({InterviewConfig.class,InterviewMavenConfig.class})
public class ManayDatasourceApp {
    public static void main(String[] args) {
        SpringApplication.run(ManayDatasourceApp.class);
    }
}
