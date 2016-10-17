package com.varhzj.lab.designpattern.creational.singleton;

/**
 * Created by varhzj on 16-10-16.
 */
public class BillPughSingleton {

    private BillPughSingleton() {}

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

}
