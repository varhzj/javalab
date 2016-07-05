package com.varhzj.lab.leetcode;

public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		int j = 0, len = nums.length;
		if(len == 0)
			return 0;

		for (int i = 0; i < len; i++) {
			if (nums[i] != nums[j]) {
				nums[++j] = nums[i];
			}
		}
		return j + 1;
	}

}
