package com.varhzj.lab.designpattern.behavioral.template;

/**
 * Created by varhzj on 10/18/16.
 */
public class WoodenHouse extends HouseTemplate {

    @Override
    protected void buildWalls() {
        System.out.println("Building wooden walls.");
    }

    @Override
    protected void buildPillars() {
        System.out.println("Building pillars with wood coating.");
    }

}
