package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.GuardedBy;
import com.varhzj.lab.concurrency.annotations.ThreadSafe;

/**
 * Created by varhzj on 11/1/16.
 */
@ThreadSafe
public class SafeSequence {

    @GuardedBy("this")
    private int value;

    public synchronized int getNext() {
        return value++;
    }

}
