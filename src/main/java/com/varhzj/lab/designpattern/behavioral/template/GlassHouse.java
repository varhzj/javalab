package com.varhzj.lab.designpattern.behavioral.template;

/**
 * Created by varhzj on 10/18/16.
 */
public class GlassHouse extends HouseTemplate {

    @Override
    protected void buildWalls() {
        System.out.println("Building glass walls.");
    }

    @Override
    protected void buildPillars() {
        System.out.println("Building pillars with glass coating.");
    }
}
