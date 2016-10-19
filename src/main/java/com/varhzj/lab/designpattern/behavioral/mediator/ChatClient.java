package com.varhzj.lab.designpattern.behavioral.mediator;

/**
 * Created by varhzj on 10/19/16.
 */
public class ChatClient {

    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();
        User ruby = new UserImpl(mediator, "Ruby");
        User java = new UserImpl(mediator, "Java");
        User c = new UserImpl(mediator, "C");
        User python = new UserImpl(mediator, "Python");

        mediator.addUser(ruby);
        mediator.addUser(java);
        mediator.addUser(c);
        mediator.addUser(python);

        java.send("Hi, I'm Java.");
        ruby.send("Hi, I'm Ruby.");
    }

}
