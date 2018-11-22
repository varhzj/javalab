package com.varhzj.lab.interview.sort;

import java.util.Arrays;
import java.util.Random;

public class Solution {

    // 快排
    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = partition(nums, left, right);
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }

    // 快排分区
    private static int partition(int[] nums, int i, int j) {
        final int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }

    public static void insertionSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int j = i + 1;
            int tmp = nums[j];
            while (j > 0 && nums[j - 1] > tmp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
    }

    public static void bubbleSort(int[] nums) {
        int length = nums.length;
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }

//        insertionSort(nums);
        bubbleSort(nums);

        printArray(nums);
    }

    private static void printArray(int[] arr) {
        Arrays.stream(arr)
                .forEach(System.out::println);
    }


}
