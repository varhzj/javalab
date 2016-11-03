package com.varhzj.lab.concurrency.examples;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by varhzj on 11/3/16.
 */
public class TestHarness {

    public long timeTasks(int nThreads, Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {

                    }
                }
            }.start();
        }

        long startTime = System.nanoTime();
        startGate.countDown();
        endGate.await();
        return System.nanoTime() - startTime;
    }

    public static void main(String[] args) {
        TestHarness th = new TestHarness();
        long timeCost = 0;
        try {
            timeCost = th.timeTasks(Runtime.getRuntime().availableProcessors(), new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "start.");
                    try {
                        TimeUnit.SECONDS.sleep(new Random().nextInt(4));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "end.");
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Total cost: " + timeCost);
    }

}
