// LeetCode Problem: 209. Minimum Size Subarray Sum
// Link: https://leetcode.com/problems/minimum-size-subarray-sum/
// Difficulty: Medium
// Tags: Sliding Window, Array, Two Pointers
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, sum = 0;
        int minLen = Integer.MAX_VALUE; // Initialize with a large number

        for (int right = 0; right < n; right++) {
            sum += nums[right]; // Expand window to the right

            // Shrink window from the left while condition is met
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left]; // Remove leftmost element from sum
                left++; // Move left pointer forward
            }
        }

        // If no valid subarray was found, return 0
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
