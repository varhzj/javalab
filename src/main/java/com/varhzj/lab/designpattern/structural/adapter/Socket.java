package com.varhzj.lab.designpattern.structural.adapter;

/**
 * Created by varhzj on 16-10-16.
 */
public class Socket {

    public Volt getVolt() {
        return new Volt(120);
    }

}
