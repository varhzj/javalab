package com.varhzj.lab.designpattern.structural.composite;

/**
 * Created by varhzj on 16-10-16.
 */
public class Triangle implements Shape {

    @Override
    public void draw(String color) {
        System.out.println("Drawing Triangle with color " + color);
    }

}
