package com.varhzj.lab.algorithms.base;

import com.varhzj.lab.algorithms.StopWatch;
import edu.princeton.cs.introcs.StdRandom;

public class ThreeSum {

    public static int count(int[] arr) {
        int length = arr.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] sizes = new int[] {
                1000,
                2000,
                3000,
                1000,
                2000,
                3000,
                4000,
                5000
        };
        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = StdRandom.uniform(-1000000, 1000000);
            }
            StopWatch stopWatch = new StopWatch();
            int count = ThreeSum.count(arr);
            double elapsedTime = stopWatch.elapsedTime();
            System.out.println("size: " + size + ", count: " + count + ", elapsedTime: " + elapsedTime);
        }

        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = StdRandom.uniform(-1000000, 1000000);
            }
            StopWatch stopWatch = new StopWatch();
            int count = ThreeSumFast.count(arr);
            double elapsedTime = stopWatch.elapsedTime();
            System.out.println("size: " + size + ", count: " + count + ", elapsedTime: " + elapsedTime);
        }

    }

}
