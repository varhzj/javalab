package com.varhzj.lab.concurrency.examples;

/**
 * Created by varhzj on 16-11-1.
 * 使内部可变状态逸出
 */
public class UnsafeStates {

    private String[] states = new String[] {
            "A", "B", "C", "D"
    };

    public String[] getStates() {
        return states;
    }
}
