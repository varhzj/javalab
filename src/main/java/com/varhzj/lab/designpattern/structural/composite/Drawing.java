package com.varhzj.lab.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by varhzj on 16-10-16.
 */
public class Drawing implements Shape {

    private List<Shape> shapes = new ArrayList<>();

    @Override
    public void draw(String color) {
        for (Shape shape : shapes) {
            shape.draw(color);
        }
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public void remove(Shape shape) {
        shapes.remove(shape);
    }

    public void clear() {
        System.out.println("Clearing all the shapes from drawing");
        shapes.clear();
    }

}
