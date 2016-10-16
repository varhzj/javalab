package com.varhzj.lab.designpattern.structural.adapter;

/**
 * Created by varhzj on 16-10-16.
 */
public interface SocketAdapter {

    Volt get120Volt();

    Volt get3Volt();

    Volt get12Volt();

}
