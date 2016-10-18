package com.varhzj.lab.designpattern.behavioral.template;

/**
 * Created by varhzj on 10/18/16.
 */
public abstract class HouseTemplate {

    // template method, use final so subclasses can't override.
    public final void build() {
        System.out.println("Start build house");
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindow();
        System.out.println("House build finish.");
    }

    protected abstract void buildWalls();

    protected abstract void buildPillars();

    private void buildWindow() {
        System.out.println("Building glass window.");
    }

    private void buildFoundation() {
        System.out.println("Building foundation.");
    }


}
