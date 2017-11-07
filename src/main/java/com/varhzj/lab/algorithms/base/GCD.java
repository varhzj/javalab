package com.varhzj.lab.algorithms.base;

public class GCD {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(10, 205));
    }

}
