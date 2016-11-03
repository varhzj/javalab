package com.varhzj.lab.concurrency.examples;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by varhzj on 16-11-3.
 */
public class BoundedHashSet<T> {

    private final Set<T> set;
    private final Semaphore semaphore;

    public BoundedHashSet(int bound) {
        set = Collections.synchronizedSet(new HashSet<T>());
        semaphore = new Semaphore(bound);
    }

    // 加入到set中，如果失败则迅速释放
    public boolean add(T o) throws InterruptedException {
        semaphore.acquire();
        boolean success = false;
        try {
            success = set.add(o);
            return success;
        } finally {
            if (!success) {
                System.out.println(Thread.currentThread().getName() + ": release semaphore with add false");
                semaphore.release();
            }
        }
    }

    public boolean remove(T o) {
        boolean success = set.remove(o);
        if (success) {
            System.out.println(Thread.currentThread().getName() + ": release semaphore with remove true");
            semaphore.release();
        }
        return success;
    }

    @Override
    public String toString() {
        return "BoundedHashSet{" +
                "set=" + set +
                ", semaphore=" + semaphore +
                '}';
    }

    public static void main(String[] args) {
        BoundedHashSet<Integer> bhs = new BoundedHashSet<>(5);
        Random r = new Random();
        Integer[] ins = new Integer[10];
        for (int i = 0; i < 10; i++) {
            ins[i] = r.nextInt();
        }

        Thread addThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Integer i : ins) {
                    try {
                        bhs.add(i);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        addThread.setName("AddThread");

        Thread rmThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    bhs.remove(ins[r.nextInt(10)]);
                }
            }
        });
        rmThread.setName("RemoveThread");

        addThread.start();
        rmThread.start();
        System.out.println(bhs);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(bhs);
    }
}
