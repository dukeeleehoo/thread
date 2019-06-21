package com.li.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        MyThread thread1 = new MyThread(countDownLatch);
        MyThread thread2 = new MyThread(countDownLatch);
        MyThread thread3 = new MyThread(countDownLatch);
        //创建线程池
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(thread1);
        es.execute(thread2);
        es.execute(thread3);
        countDownLatch.await();
        System.out.println("任务完成");
        es.shutdown();
    }



}
