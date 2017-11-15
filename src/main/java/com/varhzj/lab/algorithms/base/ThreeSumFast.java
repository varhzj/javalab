package com.varhzj.lab.algorithms.base;

import com.varhzj.lab.algorithms.StopWatch;
import edu.princeton.cs.introcs.StdRandom;

public class ThreeSumFast {

    public static int count(int[] arr) {
        int length = arr.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (BinarySearch.search(-(arr[i] + arr[j]), arr) > j) {
                    count++;
                }
            }
        }
        return count;
    }

}
