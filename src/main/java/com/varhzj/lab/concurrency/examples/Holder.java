package com.varhzj.lab.concurrency.examples;

/**
 * Created by varhzj on 11/3/16.
 */
public class Holder {

//    private int n;
    private final int n;

    public Holder(int n) {
        this.n = n;
    }

    public void assertSanity() {
        if (n != n) {
            throw new AssertionError("statement false.");
        }
    }
}
