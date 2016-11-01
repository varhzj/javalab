package com.varhzj.lab.concurrency.examples;

/**
 * Created by varhzj on 11/1/16.
 */
public class LoggingWidget extends Widget {

    @Override
    public synchronized void doSomething() {
        super.doSomething();
        System.out.println("LoggingWidget: calling doSomething.");
    }

    public static void main(String[] args) {
        LoggingWidget loggingWidget = new LoggingWidget();
        // 内置锁是可重入的，否则将产生死锁
        loggingWidget.doSomething();
    }
}
