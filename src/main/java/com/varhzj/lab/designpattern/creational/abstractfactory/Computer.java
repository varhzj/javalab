package com.varhzj.lab.designpattern.creational.abstractfactory;

/**
 * Created by varhzj on 16-10-16.
 */
public abstract class Computer {

    public abstract String getCPU();

    public abstract String getRAM();

    public abstract String getHDD();

    @Override
    public String toString() {
        return "CPU = " + this.getCPU()
                + "; RAM = " + this.getRAM()
                + "; HDD = " + this.getHDD();
    }
}
