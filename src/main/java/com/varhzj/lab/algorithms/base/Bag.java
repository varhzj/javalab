package com.varhzj.lab.algorithms.base;


public interface Bag<T> extends Iterable<T>{

    void add(T item);

    boolean isEmpty();

    int size();

}
