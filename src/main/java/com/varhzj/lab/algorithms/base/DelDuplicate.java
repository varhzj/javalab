package com.varhzj.lab.algorithms.base;

import java.util.Arrays;

public class DelDuplicate {

    public static int delDuplicate(int[] arr) {
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[index]) {
                arr[++index] = arr[i];
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        int[] arr = ArrayGenerate.genRandomInts(10);
        Arrays.sort(arr);
        System.out.println(delDuplicate(arr));
    }

}
