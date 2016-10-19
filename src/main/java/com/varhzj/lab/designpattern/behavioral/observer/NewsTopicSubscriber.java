package com.varhzj.lab.designpattern.behavioral.observer;

/**
 * Created by varhzj on 10/19/16.
 */
public class NewsTopicSubscriber implements Observer {

    private String name;
    private Subject topic;

    public NewsTopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if (msg == null) {
            System.out.println(name + ":: No new message.");
        }
        else {
            System.out.println(name + ":: Consuming message: " + msg);
        }
    }

    @Override
    public void setSubject(Subject subject) {
        this.topic = subject;
    }
}
