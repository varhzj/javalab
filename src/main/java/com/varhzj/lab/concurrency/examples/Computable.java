package com.varhzj.lab.concurrency.examples;

/**
 * Created by varhzj on 11/4/16.
 */
public interface Computable<K, V> {

    V compute(K arg) throws InterruptedException;

}
