package com.interview.config.interviewMaven;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 大都督
 * @create 2020/4/3
 */
@ConfigurationProperties(prefix = "spring.datasource.interviewmaven")
@Data
public class InterviewMavenConfig {
    private String url;
    private String userName;
    private String password;
    private int minPoolSize;
    private int maxPoolSize;
    private int maxLifetime;
    private int borrowConnectionTimeout;
    private int loginTimeout;
    private int maintenanceInterval;
    private int maxIdleTime;
    private String testQuery;
    private String uniqueResourceName;
}
