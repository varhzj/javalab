package com.varhzj.lab.mylab;

/**
 * Hello world!
 *
 */
public class App
{

    static {
        printTest();
    }

    private static final Object obj = new Object();

    public static void printTest() {
        System.out.println("A test before main");
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Thread thread1 = new Thread(() -> System.out.println("thread1"));
        thread1.start();
//        thread1.start(); // java.lang.IllegalThreadStateException
        try {
            obj.wait(); // java.lang.IllegalMonitorStateException
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
