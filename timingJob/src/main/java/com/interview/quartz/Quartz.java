package com.interview.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author 大都督
 * @create 2020/3/29
 */
public class Quartz {
    public static void main(String[] args) throws SchedulerException {
        // 创建scheduler工程
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        // 从工厂中获取调度器实例
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        // 创建jobDetail
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withDescription("this is a ").withIdentity("ramJob", "ramGroup").build();
        // 任务运行的时间，simpleSchedle类型触发器有效
        long time = System.currentTimeMillis() + 3 * 1000L;// 3秒后启动任务
        Date startTime = new Date(time);
        //创建Trigger
        // 使用SimpleScheduleBuilder或者CronScheduleBuilder
        CronTrigger ramTrigger = TriggerBuilder.newTrigger().withDescription("").withIdentity("ramTrigger").startAt(startTime).withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();// 两秒执行一次
// 注册任务和定时器
        scheduler.scheduleJob(jobDetail, ramTrigger);
    }
}
