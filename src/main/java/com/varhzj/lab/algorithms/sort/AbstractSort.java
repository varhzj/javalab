package com.varhzj.lab.algorithms.sort;

import edu.princeton.cs.introcs.StdOut;

public abstract class AbstractSort {


    public abstract void sort(Comparable[] arr);

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void show(Comparable[] arr) {
        for (Comparable anArr : arr) {
            StdOut.print(anArr + " ");
        }
        StdOut.println();
    }

}
