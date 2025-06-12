// LeetCode Problem: 238. Product of Array Except Self
// Link: https://leetcode.com/problems/product-of-array-except-self/
// Difficulty: Medium
// Tags: Array, Prefix Product
// Time Complexity: O(n)
// Space Complexity: O(1) (excluding the output array)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre = 1;
        int post = 1;
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            result[i] = 1;
        }
        for(int i=0; i<n; i++) {
            result[i] = result[i] * pre;
            pre = pre * nums[i];
        }
        for(int i=n-1; i>=0; i--) {
            result[i] = result[i] * post;
            post = post * nums[i];
        }
        return result;
    }
}
