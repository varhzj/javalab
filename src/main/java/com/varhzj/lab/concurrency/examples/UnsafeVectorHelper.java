package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.NotThreadSafe;

import java.util.Vector;

/**
 * Created by varhzj on 11/3/16.
 * NotThreadSafe vectorHelper, watch out check-then-act
 */
@NotThreadSafe
public class UnsafeVectorHelper {

    public static <E> E getLast(Vector<E> vector) {
        int lastIndex = vector.size() - 1;
        return vector.get(lastIndex);
    }

    public static <E> void deleteLast(Vector<E> vector) {
        int lastIndex = vector.size() - 1;
        vector.remove(lastIndex);
    }

}
