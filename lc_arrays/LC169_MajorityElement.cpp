// LeetCode Problem: 169. Majority Element
// Link: https://leetcode.com/problems/majority-element/
// Difficulty: Easy
// Tags: Array, Boyer-Moore, Divide and Conquer
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int count = 0, candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
};