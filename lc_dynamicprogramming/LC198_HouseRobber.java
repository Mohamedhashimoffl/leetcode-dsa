// LeetCode Problem: 198. House Robber
// Link: https://leetcode.com/problems/house-robber/
// Difficulty: Medium
// Tags: Dynamic Programming
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            // Either skip current house or rob current house + dp[i-2]
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }
}
