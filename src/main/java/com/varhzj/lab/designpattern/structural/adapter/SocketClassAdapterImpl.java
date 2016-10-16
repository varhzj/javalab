package com.varhzj.lab.designpattern.structural.adapter;

/**
 * Created by varhzj on 16-10-16.
 * Class Adapter: use java inheritance and extends the source interface
 */
public class SocketClassAdapterImpl extends Socket implements SocketAdapter {

    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get3Volt() {
        return covertVolt(getVolt(), 40);
    }

    @Override
    public Volt get12Volt() {
        return covertVolt(getVolt(), 10);
    }

    private Volt covertVolt(Volt v, int t) {
        return new Volt(v.getVolts() / t);
    }
}
