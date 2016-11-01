package com.varhzj.lab.concurrency.examples;

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
        number = 50;
        ready = true;
    }

}
