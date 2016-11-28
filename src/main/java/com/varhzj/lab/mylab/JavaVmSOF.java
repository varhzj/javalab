package com.varhzj.lab.mylab;

/**
 * Created by varhzj on 11/15/16.
 * VM args: -Xss256k
 */
public class JavaVmSOF {

    private static int stackLength = 1;

    static void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        try {
            stackLeak();
        } catch (Throwable throwable) {
            System.out.println("StackLength: " + stackLength);
            throw throwable;
        }
    }

}
