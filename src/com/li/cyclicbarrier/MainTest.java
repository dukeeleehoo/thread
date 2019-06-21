package com.li.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *cyclicbarrier 测试
 *
 *
 *  举个报旅行团旅行的例子。
 * 出发时，导游会在机场收了护照和签证，办理集体出境手续，所以，要等大家都到齐才能出发，出发前再把护照和签证发到大家手里。
 * 对应CyclicBarrier使用。
 * 每个人到达后进入barrier状态。
 * 都到达后，唤起大家一起出发去旅行。
 * 旅行出发前，导游还会有个发护照和签证的动作。
 *
 *
 */
public class MainTest {

    public static void main(String[] args) {
        //3个人相约去旅游
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new GuideTask());

        TravelTask travelTask = new TravelTask(cyclicBarrier, "唐僧", 10000);
        TravelTask travelTask1 = new TravelTask(cyclicBarrier, "悟空", 1000);
        TravelTask travelTask2 = new TravelTask(cyclicBarrier, "八戒", 6000);

        ExecutorService es = Executors.newFixedThreadPool(3);
        es.execute(travelTask);
        es.execute(travelTask1);
        es.execute(travelTask2);
        es.shutdown();
    }

}
