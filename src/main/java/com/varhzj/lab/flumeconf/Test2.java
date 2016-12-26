package com.varhzj.lab.flumeconf;

import java.io.*;

/**
 * Created by varhzj on 16-12-20.
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/huangzhijian/workspace/lab/javalab/src/main/resources/flume.conf");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

        A a1 = new A();
        System.out.println("a1: " + a1.getS());
        A a2 = new B();
        System.out.println("a2: " + a2.getS());

        B b1 = new B();
        System.out.println("b1: " + b1.getS());
        System.out.println(B.getI());
    }
}

class A {
    protected String s = "A";

    protected static Integer i = 1;

    public static Integer getI() {
        return i;
    }

    public  String getS() {
        return s;
    }

}

class B extends A {
    protected String s = "B";

    protected static Integer i = 2;

    public static Integer getI() {
        return i;
    }

    //    @Override
//    public String getS() {
//        return super.getS();
//    }

}
