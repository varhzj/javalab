package com.varhzj.lab.concurrency.examples;

import java.util.concurrent.TimeUnit;

/**
 * Created by varhzj on 16-11-1.
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }

    }

    public static void main(String[] args) {
        new ReaderThread().start();
        ready = true;
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        number = 50;
    }

}
