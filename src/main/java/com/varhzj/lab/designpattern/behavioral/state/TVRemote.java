package com.varhzj.lab.designpattern.behavioral.state;

/**
 * Created by varhzj on 10/19/16.
 */
public class TVRemote {

    public static void main(String[] args) {
        TVContext tvContext = new TVContext();
        State tvOn = new TVStartState();
        State tvOff = new TVStopState();

        tvContext.setState(tvOn);
        tvContext.doAction();

        tvContext.setState(tvOff);
        tvContext.doAction();
    }

}
