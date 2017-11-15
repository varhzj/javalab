package com.varhzj.lab.algorithms.base;

public interface Queue<T> extends Iterable<T> {

    void enqueue(T value);

    T dequeue();

    boolean isEmpty();

    int size();

}
