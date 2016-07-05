package com.varhzj.lab.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

	public static boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num))
				return true;
			map.put(num, 1);
		}
		return false;
	}

	public static boolean containsDuplicate2(int[] nums) {
		if (nums.length <= 1)
			return false;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i : nums) {
			max = Math.max(i, max);
			min = Math.min(i, min);
		}
		int[] tmp = new int[max - min + 1];
		for (int i : nums) {
			if (tmp[i - min] != 0)
				return true;
			tmp[i - min] = 1;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[] { 1, 2, 2, 3, 4 }));

	}
}
