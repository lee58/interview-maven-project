package com.interview.config.interview;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 大都督
 * @create 2020/4/3
 */
@ConfigurationProperties(prefix = "spring.datasource.interview")
@Data
public class InterviewConfig {
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
