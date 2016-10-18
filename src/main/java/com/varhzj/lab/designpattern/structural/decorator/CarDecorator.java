package com.varhzj.lab.designpattern.structural.decorator;

/**
 * Created by varhzj on 10/18/16.
 */
public class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        car.assemble();
    }

}
