package com.varhzj.lab.concurrency.examples;

import java.util.Date;

/**
 * Created by varhzj on 11/2/16.
 * this逃逸经常发生在构造函数中启动线程或注册监听器时
 */
public class ThisEscape {

    private Date date;

    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event e) {
                doSomething();
            }
        });
        date = new Date();
    }

    private void doSomething() {
        System.out.println(date);
    }

    public static void main(String[] args) {
        ThisEscape escape = new ThisEscape(new EventSource() {
            @Override
            public void registerListener(EventListener e) {
                e.onEvent(new Event() {
                });
            }
        });

        B.doSomething();
        A ab = new B();
        ab.doSomething();
        B b = new B();
        b.doSomething();
        String s;
//        System.out.println("s=" + s);
        StringBuilder sb = new StringBuilder();
        sb.append("A").append("B").append("C").append(".");
        System.out.println(sb);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
        System.out.println(System.getProperty("java.ext.dirs"));
    }


    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {}
}

class A {
    static void doSomething() {
        System.out.println("A");
    }
}

class B extends A {

    static void doSomething() {
        System.out.println("B");
    }
}
