package com.varhzj.lab.mylab.test;

public class TestInterface {

    public static void main(String[] args) {
        System.out.println(PrintColor.YELLOW);
        System.out.println(RainbowColor.YELLOW);
        System.out.println(Print.YELLOW);
        // System.out.println(PrintRainbow.YELLOW);
        // Error:(9, 40) java: reference to YELLOW is ambiguous
        // both variable YELLOW in com.varhzj.lab.mylab.test.PrintColor and variable YELLOW in com.varhzj.lab.mylab.test.RainbowColor match
    }

}


interface BaseColors {
    int RED = 1;
    int GREEN = 2;
    int BLUE = 4;
}

interface RainbowColor extends BaseColors {
    int YELLOW = 3;
    int ORANGE = 5;
    int INDIGO = 6;
    int VIOLET = 7;
}

interface PrintColor extends RainbowColor {
    int YELLOW = 8;
    int CYAN = 16;
    int MAGENTA = 32;
}

interface Print extends PrintColor {

}

interface PrintRainbow extends PrintColor, RainbowColor {

}

