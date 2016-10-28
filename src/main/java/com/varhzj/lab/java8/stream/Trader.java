package com.varhzj.lab.java8.stream;

/**
 * Created by varhzj on 10/28/16.
 */
public class Trader {

    public static final Trader NULL_TRADER = new Trader("", "");

    private String name;
    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
