package com.varhzj.lab.concurrency.examples;

/**
 * Created by varhzj on 16-11-1.
 * volatile正确使用：
 *  确保自身状态的可见性
 *  确保应用对象状态的可见性
 *  标识程序生命周期事件的发生
 */
public class CountingSheep {

    volatile boolean asleep;

    void tryToSleep() {
        while (!asleep) {
            countingSomeSheep();
        }
    }

    private void countingSomeSheep() {
    }

}
