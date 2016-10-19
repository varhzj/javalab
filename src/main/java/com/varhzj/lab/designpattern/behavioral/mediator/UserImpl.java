package com.varhzj.lab.designpattern.behavioral.mediator;

/**
 * Created by varhzj on 10/19/16.
 */
public class UserImpl extends User {

    public UserImpl(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String msg) {
        System.out.println(this.name + ": Send message = " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + ": Receive message = " + msg);
    }
}
