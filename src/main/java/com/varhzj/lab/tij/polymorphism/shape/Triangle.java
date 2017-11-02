package com.varhzj.lab.tij.polymorphism.shape;

public class Triangle extends Shape {

    @Override
    public void draw() {
        System.out.println("Trianle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Trianle.erase()");
    }
}
