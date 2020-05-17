package com.interview.threadPool;

import java.util.concurrent.*;

/**
 * @author 大都督
 * @create 2020/3/29
 */
public class ThreadPool {
    static int count = 0;
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("每隔一秒打印一次" + ++count);
            }
        };
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
    }
}
