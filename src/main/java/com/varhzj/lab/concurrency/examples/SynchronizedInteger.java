package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.GuardedBy;
import com.varhzj.lab.concurrency.annotations.ThreadSafe;

/**
 * Created by varhzj on 16-11-1.
 */
@ThreadSafe
public class SynchronizedInteger {

    @GuardedBy("this")
    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
