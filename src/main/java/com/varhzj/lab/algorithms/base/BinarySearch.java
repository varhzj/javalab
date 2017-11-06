package com.varhzj.lab.algorithms.base;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Arrays;
import java.util.Random;

import static com.varhzj.lab.algorithms.base.ArrayGenerate.genRandomInts;

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
        // 删除重复项
        int index = DelDuplicate.delDuplicate(arr);
        int[] arrNoDup = Arrays.copyOfRange(arr, 0, index);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            StdOut.println("Key: " + key + ", index: " + search(key, arr));
        }
    }



}
