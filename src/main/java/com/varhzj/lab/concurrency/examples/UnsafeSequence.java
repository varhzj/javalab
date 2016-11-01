package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.NotThreadSafe;

/**
 * Created by varhzj on 11/1/16.
 */
@NotThreadSafe
public class UnsafeSequence {

    private int value;

    public int getNext() {
        return value++;
    }

}
