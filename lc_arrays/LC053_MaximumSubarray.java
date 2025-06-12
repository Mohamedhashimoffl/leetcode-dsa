// LeetCode Problem: 53. Maximum Subarray
// Link: https://leetcode.com/problems/maximum-subarray/
// Difficulty: Medium
// Tags: Array, Dynamic Programming, Kadane's Algorithm
// Time Complexity: O(n), where n is the number of elements in the array
// Space Complexity: O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = nums[0];
        int currentsum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentsum = Math.max(nums[i], currentsum + nums[i]);
            maxsum = Math.max(maxsum, currentsum);
        }

        return maxsum;
    }
}
