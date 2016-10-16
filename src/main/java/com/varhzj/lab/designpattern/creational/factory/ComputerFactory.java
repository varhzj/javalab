package com.varhzj.lab.designpattern.creational.factory;

/**
 * Created by varhzj on 16-10-16.
 */
public class ComputerFactory {

    public static Computer getComputer(String type, String cpu, String ram, String hdd) {
        if ("pc".equalsIgnoreCase(type)) {
            return new PC(cpu, ram, hdd);
        }
        else if ("server".equalsIgnoreCase(type)) {
            return new Server(cpu, ram, hdd);
        }

        return null;
    }

}
