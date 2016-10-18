package com.varhzj.lab.designpattern.structural.bridge;

/**
 * Created by varhzj on 10/18/16.
 */
public abstract class Shape {

    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void applyColor();

}
