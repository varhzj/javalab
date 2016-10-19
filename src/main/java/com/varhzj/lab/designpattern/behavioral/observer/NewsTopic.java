package com.varhzj.lab.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by varhzj on 10/19/16.
 */
public class NewsTopic implements Subject {

    private List<Observer> observers;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    public NewsTopic() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        if (observer == null) {
            throw new NullPointerException("Null Observer");
        }

        synchronized (MUTEX) {
            if (!observers.contains(observer)) {
                observers.add(observer);
            }
        }
    }

    @Override
    public void unRegister(Observer observer) {
        synchronized (MUTEX) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersNotify = null;
        // synchronization to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed) {
                return;
            }

            observersNotify = new ArrayList<>(observers);
            this.changed = false;
        }
//        observersNotify.forEach(Observer::update);
        for (Observer observer : observersNotify) {
            observer.update();
        }
    }

    @Override
    public Object getUpdate(Observer observer) {
        return this.message;
    }

    public void postMessage(String message) {
        System.out.println("Message posted to topic: " + message);
        this.message = message;
        this.changed = true;
        notifyObservers();
    }

}
