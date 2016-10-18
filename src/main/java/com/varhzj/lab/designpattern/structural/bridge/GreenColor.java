package com.varhzj.lab.designpattern.structural.bridge;

/**
 * Created by varhzj on 10/18/16.
 */
public class GreenColor implements Color {

    @Override
    public void applyColor() {
        System.out.println("green.");
    }
}
