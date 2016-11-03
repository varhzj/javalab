package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.NotThreadSafe;
import com.varhzj.lab.concurrency.annotations.ThreadSafe;

import java.util.Vector;

/**
 * Created by varhzj on 11/3/16.
 * ThreadSafe vectorHelper, synchronized on vector
 */
@ThreadSafe
public class SafeVectorHelper {

    public static <E> E getLast(Vector<E> vector) {
        synchronized (vector) {
            int lastIndex = vector.size() - 1;
            return vector.get(lastIndex);
        }
    }

    public static <E> void deleteLast(Vector<E> vector) {
        synchronized (vector) {
            int lastIndex = vector.size() - 1;
            vector.remove(lastIndex);
        }
    }

}
