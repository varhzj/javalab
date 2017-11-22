package com.varhzj.lab.algorithms.sort;

public class ShellSort extends AbstractSort {

    @Override
    public void sort(Comparable[] arr) {
        int len = arr.length;
        int h = 1;
        while (h < len / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h) {
                    exchange(arr, j, j - h);
                }
            }
            h = h / 3;
        }
    }

}
