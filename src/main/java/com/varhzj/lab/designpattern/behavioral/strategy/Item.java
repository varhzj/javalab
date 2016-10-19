package com.varhzj.lab.designpattern.behavioral.strategy;

/**
 * Created by varhzj on 10/19/16.
 */
public class Item {

    private String upcCode;
    private double price;

    public Item(String upcCode, double price) {
        this.upcCode = upcCode;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getUpcCode() {
        return upcCode;
    }

}
