package com.varhzj.lab.concurrency;

import java.util.concurrent.locks.LockSupport;

public class TestLockSupport {

    public static void main(String[] args) {
        System.out.println("begin park!");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("end park!");
        System.out.println("another park!");
        LockSupport.park();
        System.out.println("end another park!");
    }

    /**
     * 未获取permit
     */
    private static void noPermitPark() {
        System.out.println("begin park!");
        LockSupport.park();
        System.out.println("end park");
    }

}
