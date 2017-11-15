package com.varhzj.lab.algorithms.base;

import java.util.Iterator;

public class FixedCapacityStackOfStrings implements Stack<String> {

    private String[] arr;
    private int top;

    public FixedCapacityStackOfStrings(int size) {
        arr = new String[size];
    }

    @Override
    public void push(String item) {
        arr[top++] = item;
    }

    @Override
    public String pop() {
        return arr[--top];
    }

    @Override
    public String peek() {
        return arr[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int i = top;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public String next() {
                return arr[--i];
            }
        };
    }
}
