package com.varhzj.lab.mylab;

/**
 * Created by varhzj on 1/30/17.
 */
public class SuperSub {

    /**
     * Output:
     * Sup construct
     * 0
     * Hub construct
     * @param args
     */
    public static void main(String[] args) {
        Base base = new Hub();
    }
}

abstract class Base {

    Base() {
        System.out.println("Sup construct");
        print();
    }

    abstract void print();

}

class Hub extends Base {

    int i = 10;

    Hub() {
        System.out.println("Hub construct");
    }

    @Override
    void print() {
        System.out.println(i);
    }
}

