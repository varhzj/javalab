package com.varhzj.lab.interview.dp;

import java.util.List;
import java.util.Set;

public class Solution {

    public boolean stoneGame(int[] piles) {

        int n = piles.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        for (int d = 1; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                int j = i + d;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1] > 0;
    }

    // Given a triangle, find the minimum path sum from top to bottom.
    // Each step you may move to adjacent numbers on the row below.
    public int minimumTotal(List<List<Integer>> triangle) {
        // 从下往上算
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                int old = triangle.get(i).get(j);
                triangle.get(i).set(j, old +
                        Math.min(triangle.get(i + 1).get(j),
                                triangle.get(i + 1).get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }

    public int minimumTotalM2(List<List<Integer>> triangle) {
        // 大小要大于size
        int[] res = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                res[j] = Math.min(res[j], res[j + 1]) + row.get(j);
            }
        }
        return res[0];
    }

    // Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp = Math.max(tmp + nums[i], nums[i]);
            max = Math.max(max, tmp);
        }
        return max;
    }

    public int maxProduct(int[] nums) {
        int maxLocal = nums[0];
        int minLocal = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxProd = maxLocal * nums[i];
            int minProd = minLocal * nums[i];
            maxLocal = Math.max(Math.max(maxProd, minProd), nums[i]);
            minLocal = Math.min(Math.min(minProd, maxProd), nums[i]);
            max = Math.max(maxLocal, max);
        }
        return max;
    }

    public boolean wordBreak(String s, Set<String> dict) {

        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (res[j] && dict.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }

        return res[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-4, -3, -2};
        System.out.println(solution.maxProduct(nums));
    }

}
