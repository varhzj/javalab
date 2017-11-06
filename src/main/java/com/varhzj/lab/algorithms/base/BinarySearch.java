package com.varhzj.lab.algorithms.base;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    public static int search(int key, int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < key) {
                lo = mid + 1;
            } else if (arr[mid] > key) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = genRandomInts(100);
        Arrays.sort(arr);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            StdOut.println("Key: " + key + ", index: " + search(key, arr));
        }
    }

    private static int[] genRandomInts(int count) {
        Random random = new Random();
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = random.nextInt(count);
        }
        return arr;
    }

}
