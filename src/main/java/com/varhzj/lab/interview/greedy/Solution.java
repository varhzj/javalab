package com.varhzj.lab.interview.greedy;

public class Solution {

    public int maxProfitI(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public int maxProfitII(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                sum += diff;
            }
        }
        return sum;
    }

}
