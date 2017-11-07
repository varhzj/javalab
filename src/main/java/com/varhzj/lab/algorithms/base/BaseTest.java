package com.varhzj.lab.algorithms.base;

public class BaseTest {

    public static String mystery(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        String a = s.substring(0, len /2);
        String b = s.substring(len / 2, len);
        return mystery(a) + mystery(b);
    }

    public static void main(String[] args) {
        String s = "new String()";
        System.out.println(mystery(s));

        Rational a = new Rational(4, 4);
        Rational b = new Rational(8, 4);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.minus(b));
    }

}
