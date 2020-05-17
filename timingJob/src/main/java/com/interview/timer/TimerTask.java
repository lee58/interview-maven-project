package com.interview.timer;

import java.util.Timer;

/**
 * @author 大都督
 * @create 2020/3/29
 */
public class TimerTask {
    static int count = 0;
    public static void main(String[] args) {
        java.util.TimerTask timerTask = new java.util.TimerTask() {
            @Override
            public void run() {
                System.out.println("每隔一秒打印一次" + ++count);
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }
}
