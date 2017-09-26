package com.varhzj.lab.basic;

/**
 * Created by varhzj on 5/25/17.
 */
public class InternTest {

    public static void main(String[] args) {

        String s1 = new String("Test") + new String("1");
        String s2 = s1.intern();
        System.out.println(s1 == s2);

        String s3 = new String("Test2");
        String s4 = s3.intern();
        System.out.println(s3 == s4);
    }

}
