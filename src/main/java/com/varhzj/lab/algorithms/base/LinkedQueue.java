package com.varhzj.lab.algorithms.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        private T value;
        private Node next;
    }

    @Override
    public void enqueue(T value) {
        Node old = last;
        last = new Node();
        last.value = value;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            old.next = last;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T value = first.value;
        first = first.next;
        size--;

        return value;
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
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.printf(iterator.next() + ",");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.dequeue());
        }
    }
}
