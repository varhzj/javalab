package com.varhzj.lab.leetcode;

/**
 * Created by varhzj on 4/24/17.
 */
public class MaxOne {

    public static void main(String[] args) {
        int max = (int) Math.pow(2, 7);
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = maxOne(i);
            System.out.println(i + ", " + Integer.toBinaryString(i) + ", " + res[i]);
        }
    }

    private static int maxOne(int n) {
        int count = 0;
        int max = 0;

        while (n != 0) {
            while ((n & 1) == 1 && n != 0) {
                count++;
                n >>= 1;
            }

            if (max < count) {
                max = count;
            }

            while ((n & 1) != 1 && n != 0) {
                n >>= 1;
            }

            count = 0;
        }

        return max;
    }

}
