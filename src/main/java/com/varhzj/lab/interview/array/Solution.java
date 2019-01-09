package com.varhzj.lab.interview.array;

import java.util.*;

/**
 * Created by varhzj on 12/13/16.
 */
public class Solution {

    public List<Integer> travelMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        List<Integer> res = new ArrayList<>(rowSize * colSize);
        int startRow = 0;
        int endRow = rowSize - 1;
        int startCol = 0;
        int endCol = colSize - 1;

        while (startRow <= endRow && startCol <= endCol) {

            for (int i = startCol; i <= endCol; i++) {
                res.add(matrix[startRow][i]);
            }
            startRow++;

            for (int i = startRow; i <= endRow; i++) {
                res.add(matrix[i][endCol]);
            }
            endCol--;

            for (int i = endCol; i >= startCol && endRow >= startRow; i--) {
                res.add(matrix[endRow][i]);
            }
            endRow--;

            for (int i = endRow; i >= startRow && endCol >= startCol; i--) {
                res.add(matrix[i][startCol]);
            }
            startCol++;
        }

        return res;
    }

    // kth element in array
    public int kthElement(int[] arr, int k) {

        int start = 0;
        int end = arr.length - 1;
        while (true) {
            int partition = partition(arr, start, end);
            if (partition == k - 1) {
                return arr[partition];
            } else if (partition < k - 1) {
                start = partition + 1;
            } else {
                end = partition - 1;
            }
        }

    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        while (start < end) {
            while (start < end && arr[end] <= pivot) { // 从后找到大于pivot的值放到前面
                end--;
            }
            arr[start] = arr[end];

            while (start < end && arr[start] >= pivot) { // 从前找到小于pivot的值放到后面
                start++;
            }
            arr[end] = arr[start];
        }

        arr[start] = pivot;

        return start;
    }

    // 删除数组中的某个元素，并返回新数组的长度
    public int rmElement(int[] arr, int value) {
        if (arr == null) {
            return 0;
        }

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                continue;
            }
            arr[j++] = arr[i];
        }
        return j;
    }


    // 求出数组中两个相加为指定值的位置，从0开始，假设有且仅有一个结果
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    // 求出数组中两个相加为指定值的数组，从0开始，可以有多个结果
    public List<int[]> twoSumDup(int[] nums, int target) {
        List<int[]> list = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            int tmp = target - num;
            if (map.get(tmp) != null && !map.get(tmp)) {
                list.add(new int[]{num, tmp});
                // 标识已使用
                map.put(num, true);
                map.put(tmp, true);
            } else {
                map.put(num, false);
            }
        }
        return list;
    }

    static class Tupple<T, R> {
        T t;
        R r;

        public Tupple(T t, R r) {
            this.t = t;
            this.r = r;
        }
    }

    // 删除有序数组中的重复元素
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    // 删除数组中的指定元素
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    // 数组加一
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    // 合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i > -1 && j > -1) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j > -1) {
            nums1[j] = nums2[j--];
        }
    }

    // 生成指定行数的Pascal三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            if (i > 0) {
                row.add(1);
            }
            res.add(row);
        }
        return res;
    }

    // 获取Pascal三角的第n行
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            res.add(1);
            for (int j = i - 1; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }

    // Best Time to Buy and Sell Stock, 只能买卖各一次
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int res = 0;
        int min = prices[0];
        int profit = 0;
        for (int price : prices) {
            min = price < min ? price : min;
            profit = price - min;
            res = profit > res ? profit : res;
        }
        return res;
    }

    // Majority Element: The majority element is the element that appears more than ⌊ n/2 ⌋ times.
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count++;
                res = nums[i];
            } else if (res == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }


    // Rotate Array: Rotate an array of n elements to the right by k steps.
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int rotate = k % length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, rotate - 1);
        reverse(nums, rotate, length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[j] ^ nums[i];
            nums[i] = nums[i] ^ nums[j];
            i++;
            j--;
        }
    }

    // Contains Duplicate: 判断数组中是否有重复元素
    public boolean containsDuplicate(int[] nums) {
        // 以下方法只适用于正数数组
//        BitSet bitSet = new BitSet();
//        for (int num : nums) {
//            if (bitSet.get(num)) {
//                return true;
//            } else {
//                bitSet.set(num);
//            }
//        }
//        return false;
        // 超时
//        Map<Integer, Boolean> map = new HashMap<>();
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                return true;
//            } else {
//                map.put(num, true);
//            }
//        }
//        return false;

        final Set<Integer> distinct = new HashSet<Integer>();
        for (int num : nums) {
            if (distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }

    // Given an array of integers and an integer k,
    // find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null && i - index <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    // Missing Number:
    // Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
    // find the one that is missing from the array.
    public int missingNumber(int[] nums) {
        int xor = 0;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }

    // Move Zeroes:
    // Given an array nums,
    // write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                while (nums[j] == 0) {
                    j++;
                    if (j == nums.length) {
                        return;
                    }
                }
                swap(nums, i, j);
            }
        }
    }

    public void moveZeroesII(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
//                int temp = nums[j];
//                nums[j] = nums[i];
//                nums[i] = temp;
                if (j != i) {
                    swap(nums, i, j);
                }
                j++;
            }
        }
    }

    // take care: i != j
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[j] ^ nums[i];
        nums[i] = nums[i] ^ nums[j];
    }


    // 给定一个长度为n的数组，数组中元素1<=arr[i]<=n，相同元素最多出现两次，求数组中未出现的元素
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (nums[Math.abs(val) - 1] > 0) {
                nums[Math.abs(val) - 1] = -nums[Math.abs(val) - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    // Given two strings s and t which consist of only lowercase letters.
    // String t is generated by random shuffling string s and then add one more letter at a random position.
    // Find the letter that was added in t.
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        int sLen = s.length();
        for (int i = 0; i < t.length(); i++) {
            if (i < sLen) {
                arr[s.charAt(i) - 'a'] += 1;
            }
            arr[t.charAt(i) - 'a'] -= 1;
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                return (char) (j + 'a');
            }
        }
        return ' ';
    }

    // There are N children standing in a line. Each child is assigned a rating value.
    // You are giving candies to these children subjected to the following requirements:
    // * Each child must have at least one candy.
    // * Children with a higher rating get more candies then their neighbors.
    // what is the minimum candies you must have?
    public int candy(int[] ratings) {
        int n = ratings.length;
        // 相对于基础candy数的增量数组
        int[] incs = new int[n];
        // 从左到右遍历,递增则在前一个基础上+1
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                incs[i + 1] = incs[i] + 1;
            }
        }
        // 从右向左遍历,递增取当前与后一个+1最大值
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                incs[i - 1] = Math.max(incs[i - 1], incs[i] + 1);
            }
        }
        // 基础为一人一个
        int sum = n;
        for (int inc : incs) {
            sum += inc;
        }

        return sum;
    }

    // Given n non-negative integers representing an elevation map where the width of each bar is 1,
    // compute how much water it is able to trap after raining.
    //
    // For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];

        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }

        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            int min = Math.min(left[i], right[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }

        return sum;
    }

    //There are two sorted arrays nums1 and nums2 of size m and n respectively.
    //
    //Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
    //
    //You may assume nums1 and nums2 cannot be both empty.
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // TODO
        return 0;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(4));
        System.out.println(solution.getRow(10));
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(nums));
        printArray(nums);
//        Long l = 1L;
//        Integer i = (Integer) l;
    }

    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

}
