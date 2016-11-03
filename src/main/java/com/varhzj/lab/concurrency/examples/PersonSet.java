package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.GuardedBy;
import com.varhzj.lab.concurrency.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by varhzj on 11/3/16.
 * Using confinement to ensure thread safety
 * 线程安全，但是无法保证符合操作线程安全性，需要客户端代码做同步处理
 */
@ThreadSafe
public class PersonSet {

    @GuardedBy("this")
    private final Set<Person> personSet = new HashSet<>();

    public synchronized void addPerson(Person p) {
        personSet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return personSet.contains(p);
    }

    interface Person {}

}
