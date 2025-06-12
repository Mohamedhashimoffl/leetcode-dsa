// Problem: 121. Best Time to Buy and Sell Stock
// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Difficulty: Easy
// Tags: Array, Dynamic Programming, Greedy
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                int profit = prices[i] - min;
                if (profit > max) {
                    max = profit;
                }
            }
        }
        return max;
    }
}
