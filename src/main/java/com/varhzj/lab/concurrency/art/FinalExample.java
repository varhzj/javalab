package com.varhzj.lab.concurrency.art;

import java.util.concurrent.TimeUnit;

/**
 * Created by varhzj on 11/24/16.
 */
public class FinalExample {

    int i;
    final int j;

    static FinalExample obj;

    public FinalExample() {
        j = 2;
        i = 1;
    }

    public static void writer() {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            // ignore
        }
        obj = new FinalExample();
    }

    public static void reader() {
        FinalExample object = obj;
        System.out.println("i = " + object.i);
        System.out.println("j = " + object.j);
    }

    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> writer());
        writerThread.start();
        Thread readerThread = new Thread(() -> reader());
        readerThread.start();

    }

}
