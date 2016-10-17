package com.varhzj.lab.designpattern.structural.adapter;

/**
 * Created by varhzj on 16-10-16.
 * Object Adapter: use java composition and adapter contains the source object
 */
public class SocketObjectAdapterImpl implements SocketAdapter{

    private Socket socket = new Socket();

    @Override
    public Volt get120Volt() {
        return socket.getVolt();
    }

    @Override
    public Volt get3Volt() {
        return convertVolt(socket.getVolt(), 40);
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(socket.getVolt(), 10);
    }

    private Volt convertVolt(Volt v, int t) {
        return new Volt(v.getVolts() / t);
    }
}
