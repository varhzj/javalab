package com.varhzj.lab.designpattern.behavioral.mediator;

/**
 * Created by varhzj on 10/19/16.
 */
public interface ChatMediator {

    void sendMessage(String msg, User user);

    void addUser(User user);

}
