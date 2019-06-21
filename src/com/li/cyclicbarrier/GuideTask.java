package com.li.cyclicbarrier;

public class GuideTask implements Runnable {
    @Override
    public void run() {
        System.out.println("导游给游客发放签证!");
    }
}
