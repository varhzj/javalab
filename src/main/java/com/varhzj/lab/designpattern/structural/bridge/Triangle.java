package com.varhzj.lab.designpattern.structural.bridge;

/**
 * Created by varhzj on 10/18/16.
 */
public class Triangle extends Shape {

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.printf("Triangle filled with color ");
        color.applyColor();
    }
}
