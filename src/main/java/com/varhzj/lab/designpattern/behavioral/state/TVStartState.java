package com.varhzj.lab.designpattern.behavioral.state;

/**
 * Created by varhzj on 10/19/16.
 */
public class TVStartState implements State {

    @Override
    public void doAction() {
        System.out.println("TV turned on.");
    }

}
