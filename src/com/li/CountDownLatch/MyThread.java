package com.li.CountDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 创建线程类  使用countdownlatch 计数器
 */
public class MyThread extends Thread {

    private CountDownLatch countDownLatch;

    public MyThread(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10000-2000)+2000);
            System.out.println(this.getName()+" 完成任务");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
