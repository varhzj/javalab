package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.ThreadSafe;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Created by varhzj on 11/3/16.
 * 通过扩展现有类添加方法，并保证线程安全
 */
@ThreadSafe
public class BetterVector<E> extends Vector<E> {

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !contains(x);
        if (absent) {
            add(x);
        }
        return absent;
    }

    public static void main(String[] args) {
        BetterVector<String> betterVector = new BetterVector<>();
        betterVector.addAll(Arrays.asList("Java", "Ruby"));
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(betterVector.putIfAbsent("Python"));
                System.out.println(betterVector.putIfAbsent("Java"));
            }
        }).start();
        betterVector.add("Python");
    }

}
