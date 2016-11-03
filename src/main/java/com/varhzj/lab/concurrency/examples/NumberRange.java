package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.NotThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by varhzj on 11/3/16.
 * 类中存在多个状态切状态之间存在关联性时，不能将依靠线程安全代理直接实现
 */
@NotThreadSafe
public class NumberRange {

    // lower <= upper
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void setLower(int i) {
        // Warning: unsafe check-then-act
        if (i > upper.get()) {
            throw new IllegalArgumentException("Cannot set lower to " + i + " > upper.");
        }
        lower.set(i);
    }

    public void setUpper(int i) {
        // Warning: unsafe check-then-act
        if (i < lower.get()) {
            throw new IllegalArgumentException("Cannot set upper to " + i + " < lower.");
        }
        upper.set(i);
    }

    public boolean isInRange(int i) {
        return i >= lower.get() && i <= upper.get();
    }

    @Override
    public String toString() {
        return "NumberRange{" +
                "lower=" + lower.get() +
                ", upper=" + upper.get() +
                '}';
    }

    public static void main(String[] args) {
        NumberRange range = new NumberRange();
        range.setLower(0);
        range.setUpper(10);
        new Thread(new Runnable() {
            @Override
            public void run() {
                range.setUpper(4);
                System.out.println(range);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                range.setLower(5);
                System.out.println(range);
            }
        }).start();
        System.out.println(range);
    }
}
