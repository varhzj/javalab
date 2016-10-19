package com.varhzj.lab.designpattern.behavioral.state;

/**
 * Created by varhzj on 10/19/16.
 */
public class TVContext implements State {

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    @Override
    public void doAction() {
        state.doAction();
    }
}
