package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.Immutable;

/**
 * Created by varhzj on 11/3/16.
 * Immutable Point class used by DelegatingVehicleTracker.
 */
@Immutable
public class ImmutablePoint {

    private final int x;
    private final int y;

    public ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "ImmutablePoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
