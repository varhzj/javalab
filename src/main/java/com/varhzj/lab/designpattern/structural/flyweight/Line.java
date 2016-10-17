package com.varhzj.lab.designpattern.structural.flyweight;

import java.util.concurrent.TimeUnit;

/**
 * Created by varhzj on 10/17/16.
 */
public class Line implements Shape {

    public Line() {
        System.out.println("Create Line object.");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(String color) {
        System.out.println("Draw Line with color " + color);
    }

}
