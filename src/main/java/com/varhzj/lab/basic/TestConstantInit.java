package com.varhzj.lab.basic;

public class TestConstantInit {

    public static void main(String[] args) {
        String s = Constant.C_S;
        System.out.println("After C_S");
        String s1 = Constant.C_S_0;
        System.out.println("After C_S_0");
        Object o = Constant.C_O;
        System.out.println("After C_O");
    }

}
