package com.varhzj.lab.concurrency.examples;

/**
 * Created by varhzj on 11/2/16.
 * 使用工厂方法防止this在构造过程中逃逸
 */
public class SafeListener {

    private final EventListener listener;

    private SafeListener() {
        listener = new EventListener() {
            @Override
            public void onEvent(Event e) {
                doSomething();
            }
        };
    }

    public SafeListener getInstance(EventSource eventSource) {
        SafeListener safeListener = new SafeListener();
        eventSource.registerListener(safeListener.listener);
        return safeListener;
    }

    private void doSomething() {

    }

    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {}

}
