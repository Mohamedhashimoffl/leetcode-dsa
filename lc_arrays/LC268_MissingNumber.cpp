// LeetCode Problem: 268. Missing Number
// Link: https://leetcode.com/problems/missing-number/
// Difficulty: Easy
// Tags: Array, Math, Bit Manipulation
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int a = nums.size();
        int sum = a * (a + 1) / 2;
        int sum1 = 0;
        for (int n : nums) {
            sum1 += n;
        }
        return sum - sum1;
    }
};
