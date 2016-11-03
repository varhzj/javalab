package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.GuardedBy;

/**
 * Created by varhzj on 11/3/16.
 * Guarding state with a private lock
 * take care private final Object obj = new Object();
 * Making the lock object private encapsulates the lock so that client code cannot acquire it,
 * whereas a publicly accessible lock allows client code to participate in its synchronization policy-correctly or incorrectly.
 * Clients that improperly acquire another object’s lock could cause liveness problems,
 * and verifying that a publicly accessible lock is properly used requires examining the entire program rather than a single class.
 */
public class PrivateLock {

    private final Object pLock = new Object();
    @GuardedBy("pLock")
    private Widget widget;

    public void someMethod() {
        synchronized (pLock) {
            // Access or modify the state of widget
            widget.doSomething();
        }
    }

}
