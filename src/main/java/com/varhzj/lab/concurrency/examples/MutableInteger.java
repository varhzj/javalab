package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.NotThreadSafe;

/**
 * Created by varhzj on 16-11-1.
 */
@NotThreadSafe
public class MutableInteger {

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
