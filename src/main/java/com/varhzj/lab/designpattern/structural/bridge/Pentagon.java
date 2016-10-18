package com.varhzj.lab.designpattern.structural.bridge;

/**
 * Created by varhzj on 10/18/16.
 */
public class Pentagon extends Shape {


    public Pentagon(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.printf("Pentagon filled with color ");
        color.applyColor();
    }
}
