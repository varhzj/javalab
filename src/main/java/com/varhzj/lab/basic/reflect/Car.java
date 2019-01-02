package com.varhzj.lab.basic.reflect;

public class Car {

    private String color;

    public Car() {
    }

    public Car(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                '}';
    }
}
