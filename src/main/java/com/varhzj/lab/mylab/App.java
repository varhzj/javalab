package com.varhzj.lab.mylab;

import java.io.*;
import java.util.BitSet;

/**
 * Hello world!
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

        }

//        BitSet bs1 = new BitSet(12);
//        bs1.set(1);
//        bs1.set(2, false);
//        System.out.println(bs1);
//        System.out.println("Hello World!");
        File file = new File("/Users/varhzj/WorkSpace/hosts");
        System.out.println("File name: "  + file.getName());
        System.out.println("Path: " + file.getPath());
        System.out.println("Abs Path: " + file.getAbsolutePath());

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("data.txt"))){
            outputStream.writeDouble(89.22);
            outputStream.writeInt(100);
            outputStream.writeBoolean(false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream("data.txt"))){
            System.out.println(inputStream.readDouble()+ "; \n" + inputStream.readInt() + "; \n" + inputStream.readBoolean() );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
