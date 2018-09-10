package com.varhzj.lab.algorithms.sort;

public class MergeSort extends AbstractSort {


    @Override
    public void sort(Comparable[] arr) {

    }

    public static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = 0; k <= hi; k++) {
            if (i > mid) arr[k] = aux[j++];   // this copying is unnecessary
            else if (j > hi) arr[k] = aux[i++];
            else if (less(aux[j], aux[i])) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }
    }

}
