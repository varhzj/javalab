package com.varhzj.lab.algorithms.base;

import java.util.Random;

public class ArrayGenerate {

    public static int[] genRandomInts(int count) {
        Random random = new Random();
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = random.nextInt(count);
        }
        return arr;
    }
}
