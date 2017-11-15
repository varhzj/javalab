package com.varhzj.lab.algorithms.base;

import java.util.Iterator;

public class LinkedBag<T> implements Bag<T> {

    private Node first;
    private int size;

    private class Node {
        private T t;
        private Node next;
    }

    @Override
    public void add(T item) {
        Node old = first;
        first = new Node();
        first.t = item;
        first.next = old;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node curr = first;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T t = curr.t;
                curr = curr.next;
                return t;
            }
        };
    }
}
