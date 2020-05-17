package com.interview.thread;

/**
 * @author 大都督
 * @create 2020/3/29
 */
public class ThreadTimingJob {

        static int count = 0;
        public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("每隔一秒打印一次" + ++count);
                }
            }
        }).start();
    }

}
