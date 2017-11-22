package com.varhzj.lab.algorithms.sort;

public class InsertionSort extends AbstractSort {

    @Override
    public void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                exchange(arr, j, j - 1);
            }
        }
    }

}
