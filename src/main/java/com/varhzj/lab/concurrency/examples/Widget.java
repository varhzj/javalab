package com.varhzj.lab.concurrency.examples;

/**
 * Created by varhzj on 11/1/16.
 */
public class Widget {

    public synchronized void doSomething() {
        System.out.println("Widget: doSomething.");
    }

}
