package com.varhzj.lab.designpattern.creational.singleton;

/**
 * Created by varhzj on 16-10-16.
 */
public class ThreadSafeSingleton {

    private volatile static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}

    public synchronized static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

}
