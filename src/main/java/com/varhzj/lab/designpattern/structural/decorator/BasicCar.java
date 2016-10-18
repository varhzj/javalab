package com.varhzj.lab.designpattern.structural.decorator;

/**
 * Created by varhzj on 10/18/16.
 */
public class BasicCar implements Car {

    @Override
    public void assemble() {
        System.out.println("Basic Car.");
    }

}
