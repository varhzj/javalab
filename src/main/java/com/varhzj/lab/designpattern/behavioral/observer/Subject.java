package com.varhzj.lab.designpattern.behavioral.observer;

/**
 * Created by varhzj on 10/19/16.
 */
public interface Subject {

    // method to register observers
    void register(Observer observer);

    // method to unregister observers
    void unRegister(Observer observer);

    // method to notify observers of change
    void notifyObservers();

    // method to get updates from subject
    Object getUpdate(Observer observer);

}
