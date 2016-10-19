package com.varhzj.lab.designpattern.behavioral.observer;

/**
 * Created by varhzj on 10/19/16.
 */
public interface Observer {

    // method to update the observer, used by subject
    void update();

    // attach with subject to observe
    void setSubject(Subject subject);

}
