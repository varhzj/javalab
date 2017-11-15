package com.varhzj.lab.algorithms.base;

import java.util.Arrays;

public class TwoSumFast {

    public static int count(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (BinarySearch.search(-arr[i], arr) > i) {
                count++;
            }
        }
        return count;
    }

}
