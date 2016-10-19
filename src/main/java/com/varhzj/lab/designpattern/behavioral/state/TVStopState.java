package com.varhzj.lab.designpattern.behavioral.state;

/**
 * Created by varhzj on 10/19/16.
 */
public class TVStopState implements State {

    @Override
    public void doAction() {
        System.out.println("TV turned off.");
    }

}
