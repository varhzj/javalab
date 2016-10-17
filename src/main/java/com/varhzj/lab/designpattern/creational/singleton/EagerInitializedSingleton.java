package com.varhzj.lab.designpattern.creational.singleton;

/**
 * Created by varhzj on 16-10-16.
 */
public class EagerInitializedSingleton {

    private static EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {}

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}
