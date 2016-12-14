package com.varhzj.lab.concurrency.art;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by varhzj on 11/24/16.
 */
public class ConnectionPoolTest {

    static final int THREAD_COUNT = 50;
    static final int COUNT = 20;

    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch startLatch = new CountDownLatch(1);
    static CountDownLatch endLatch = new CountDownLatch(THREAD_COUNT);

    static class ConnectionRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                startLatch.await();
            } catch (InterruptedException e) {
                // ignore
            }
            while (count > 0) {
                try {
                    Connection connection = pool.getConnection(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            endLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger got = new AtomicInteger(0);
        AtomicInteger notGot = new AtomicInteger(0);
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(new ConnectionRunner(COUNT, got, notGot), "ConnectionRunner" + i).start();
        }
        startLatch.countDown();
        endLatch.await();
        System.out.println("total invoke: " + (THREAD_COUNT * COUNT));
        System.out.println("got connection: " + got.get());
        System.out.println("not got connection: " + notGot.get());
    }

}
