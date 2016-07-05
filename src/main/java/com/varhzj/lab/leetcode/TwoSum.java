package com.varhzj.lab.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * UPDATE (2016/2/13):
 * The return format had been changed to zero-based indices.
 * Please read the above updated description carefully.
*/
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		int[] results = { -1, -1 };

		Map<Integer, Integer> map = new HashMap<>();
		int len = nums.length;
		for (int i = 0; i < len; i++)
			map.put(nums[i], i);

		int minus = 0;
		for (int i = 0; i< len; i++) {
			minus = target - nums[i];
			if (map.containsKey(minus)) {
				int j = map.get(minus);
				if (j > i) {
					results[0] = i;
					results[1] = j;
					return results;
				}
			}
		}

		return results;
	}

}
