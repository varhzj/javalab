package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.GuardedBy;
import com.varhzj.lab.concurrency.annotations.ThreadSafe;

/**
 * Created by varhzj on 11/3/16.
 */
@ThreadSafe
public class SafePoint {

    @GuardedBy("this")
    private int x;
    @GuardedBy("this")
    private int y;

    private SafePoint(int[] a) {
        this(a[0], a[1]);
    }

    public SafePoint(SafePoint point) {
        this(point.get());
    }

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int[] get() {
        return new int[]{x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
