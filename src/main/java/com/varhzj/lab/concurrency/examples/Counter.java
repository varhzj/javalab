package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.GuardedBy;
import com.varhzj.lab.concurrency.annotations.ThreadSafe;

/**
 * Created by varhzj on 11/3/16.
 */
@ThreadSafe
public class Counter {

    @GuardedBy("this")
    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized int increment() {
        if (value == Integer.MAX_VALUE) {
            throw new IllegalStateException("Counter overflow.");
        }
        return ++value;
    }
}
