package com.varhzj.lab.mylab;

/**
 * Created by varhzj on 3/14/17.
 */
public class Test {

    private Test test;

    static int a = 1;

    public Test() {
        System.out.println(a++);
        test = new Test();
//        test = new Test(2);
    }

    public Test(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.a);
    }
}
