package com.varhzj.lab.designpattern.creational.abstractfactory;

/**
 * Created by varhzj on 16-10-16.
 */
public class ServerFactory implements ComputerAbstractFactory {

    private String cpu;
    private String ram;
    private String hdd;

    public ServerFactory(String cpu, String ram, String hdd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }

    @Override
    public Computer createComputer() {
        return new PC(cpu, ram, hdd);
    }
}
