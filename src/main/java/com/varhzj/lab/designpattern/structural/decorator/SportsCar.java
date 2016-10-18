package com.varhzj.lab.designpattern.structural.decorator;

/**
 * Created by varhzj on 10/18/16.
 */
public class SportsCar extends CarDecorator {

    public SportsCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Car add sports feature.");
    }
}
