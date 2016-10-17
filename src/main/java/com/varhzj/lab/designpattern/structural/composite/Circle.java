package com.varhzj.lab.designpattern.structural.composite;

/**
 * Created by varhzj on 16-10-16.
 */
public class Circle implements Shape {

    @Override
    public void draw(String color) {
        System.out.println("Drawing Circle with color " + color);
    }

}
