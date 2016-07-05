package com.varhzj.lab.leetcode;

public class InvertBTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;

		TreeNode tmp = invertTree(root.left);
		root.left = invertTree(root.right);
		root.right = tmp;

		return root;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 0, 3, 12, 10, 0, 13, 0, 14, 0 };
		int i = 0, len = nums.length;

		while (nums[i] != 0)
			i++;
		if (i > len)
			return;
		int j = i + 1;

		while (j < len) {

			while (j < len && nums[j] == 0)
				j++;

			if (j < len) {
				nums[i] = nums[j];
				nums[j] = 0;
				i++;
			}
		}

		for (int num : nums) {
			System.out.println(num);
		}
	}

}
