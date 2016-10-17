package com.varhzj.lab.designpattern.structural.flyweight;

import java.util.concurrent.TimeUnit;

/**
 * Created by varhzj on 10/17/16.
 */
public class Oval implements Shape {

    private boolean fill;

    public Oval(boolean isFill) {
        this.fill = isFill;
        System.out.println("Create Oval object with fill = " + fill);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(String color) {
        if (fill) {
            System.out.println("Draw Oval fill with " + color);
        }
        else {
            System.out.println("Draw Oval with " + color);
        }
    }

}
