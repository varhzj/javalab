package com.varhzj.lab.basic;

public class Constant {


    public static final String C_S = "constant a";

    public static final String C_S_0;

    public static final Object C_O = new Object();

    static {
        System.out.println("Constant cinit");
        C_S_0 = "Constant s0";
    }

}
