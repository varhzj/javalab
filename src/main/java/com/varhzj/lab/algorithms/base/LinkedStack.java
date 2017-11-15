package com.varhzj.lab.algorithms.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stack<T> {

    private Node first;
    private int size;

    private class Node {
        private T value;
        private Node next;
    }

    @Override
    public void push(T item) {
        Node old = first;
        first = new Node();
        first.value = item;
        first.next = old;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }

        T value = first.value;
        first = first.next;
        size--;
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return first.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
        Stack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }

        stack.pop();

        Stack<String>[] stacks = new Stack[10];
//        stacks[0] = new LinkedStack<Integer>();
        stacks[0] = new ResizingArrayStack<String>();
    }
}
