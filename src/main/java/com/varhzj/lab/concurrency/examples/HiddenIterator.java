package com.varhzj.lab.concurrency.examples;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by varhzj on 11/3/16.
 * 隐式迭代
 */
public class HiddenIterator {

    private final Set<Integer> set = new HashSet<>();

    public synchronized void add(Integer s) {
        set.add(s);
    }

    public synchronized void remove(Integer s) {
        set.remove(s);
    }

    public void addTenThings() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            set.add(random.nextInt());
        }
//        set.toString();
        // 调用了set的toString()方法，隐式调用了set的iterator
        System.out.println("Add ten elements to " + set);
    }

}
