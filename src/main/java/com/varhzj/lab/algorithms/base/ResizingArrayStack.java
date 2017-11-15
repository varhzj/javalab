package com.varhzj.lab.algorithms.base;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<T> implements Stack<T> {

    private T[] arr = (T[]) new Object[1];
    private int size = 0;

    @Override
    public void push(T item) {
        if (size == arr.length) {
            resize(arr.length * 2);
        }
        arr[size++] = item;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }

        T t = arr[--size];
        arr[size] = null; // help GC
        if (size > 0 && size == arr.length / 4) {
            resize(arr.length / 2);
        }
        return t;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return arr[size - 1];
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
            private int i = size;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return arr[--i];
            }

        };
    }

    private void resize(int newSize) {
        System.out.println("Curr size: " + arr.length + ", resize to: " + newSize);
        arr = Arrays.copyOf(arr, newSize);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ResizingArrayStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }

        stack.pop();

    }
}
