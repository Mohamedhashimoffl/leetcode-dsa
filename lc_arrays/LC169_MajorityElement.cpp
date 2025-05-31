// LeetCode Problem: 169. Majority Element
// Link: https://leetcode.com/problems/majority-element/
// Difficulty: Easy

// Tags: Array, Counting
// Time Complexity: O(n^2) due to nested loops counting occurrences
// Space Complexity: O(1) constant extra space

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int n = nums.size();
        int x = n / 2;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(nums[i] == nums[j]) {
                    count++;
                }
            }
            if(count > x) {
                return nums[i];
            }
        }
        return -1;
    }
};
