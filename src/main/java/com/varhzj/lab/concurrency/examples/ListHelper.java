package com.varhzj.lab.concurrency.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by varhzj on 11/3/16.
 */
public class ListHelper<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    // synchronized on the wrong lock
    public synchronized boolean putIfAbsent0(E x) {
        boolean absent = !list.contains(x);
        if (absent) {
            list.add(x);
        }
        return absent;
    }

    // thread safe
    public boolean putIfAbsent(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent) {
                list.add(x);
            }
            return absent;
        }
    }

}
