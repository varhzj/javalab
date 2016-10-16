package com.varhzj.lab.designpattern.creational.factory;

/**
 * Created by varhzj on 16-10-16.
 */
public class Server extends Computer {

    private String cpu;
    private String ram;
    private String hdd;

    public Server(String cpu, String ram, String hdd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }

    @Override
    public String getCPU() {
        return cpu;
    }

    @Override
    public String getRAM() {
        return ram;
    }

    @Override
    public String getHDD() {
        return hdd;
    }
}
