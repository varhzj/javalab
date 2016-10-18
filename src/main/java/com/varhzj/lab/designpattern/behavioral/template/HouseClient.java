package com.varhzj.lab.designpattern.behavioral.template;

/**
 * Created by varhzj on 10/18/16.
 */
public class HouseClient {

    public static void main(String[] args) {
        HouseTemplate house = new WoodenHouse();
        house.build();

        System.out.println("************************************");

        house = new GlassHouse();
        house.build();
    }

}
