package com.varhzj.lab.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {

	/**
	 * Given an array of size n, find the majority element. The majority element
	 * is the element that appears more than ⌊ n/2 ⌋ times. You may assume that
	 * the array is non-empty and the majority element always exist in the
	 * array.
	 *
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		int count = 0, result = 0;
		for (int num : nums) {
			if (count == 0) {
				result = num;
				count++;
			} else if (result == num)
				count++;
			else
				count--;
		}
		return result;
	}

	/**
	 * Given an integer array of size n, find all elements that appear more than
	 * ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
	 *
	 * @param nums
	 * @return
	 */
	public static List<Integer> majorityElements(int[] nums) {
		if (nums == null || nums.length == 0)
			return new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1)
				count1++;
			else if (nums[i] == number2)
				count2++;
			else if (count1 == 0) {
				number1 = nums[i];
				count1 = 1;
			} else if (count2 == 0) {
				number2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1)
				count1++;
			else if (nums[i] == number2)
				count2++;
		}
		if (count1 > len / 3)
			result.add(number1);
		if (count2 > len / 3)
			result.add(number2);
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1, 3, 2, 4, 2, 3, 2, 3 };
		List<Integer> res = majorityElements(nums);
		for (int i : res)
			System.out.println(i);
	}

}
