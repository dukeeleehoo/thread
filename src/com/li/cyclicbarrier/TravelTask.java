package com.li.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class TravelTask implements Runnable {

    private CyclicBarrier cyclicBarrier;
    //姓名
    private String name;
    //到达时间
    private int arrTime;

    public TravelTask(CyclicBarrier cyclicBarrier, String name, int arrTime) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
        this.arrTime = arrTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(arrTime);
            System.out.println(name+"花了"+arrTime+" 毫秒赶到集合地点!");
            cyclicBarrier.await();
            System.out.println(name+"开始旅游!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
