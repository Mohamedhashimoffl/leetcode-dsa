// LeetCode Problem: 1. Two Sum
// Link: https://leetcode.com/problems/two-sum/
// Tags: Array, Brute Force, Hash Table (optimal approach exists)
// Time Complexity: O(n^2)
// Space Complexity: O(1)
#include <vector>
using namespace std;
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return {i, j}; // Return indices of the two numbers
                }
            }
        }
        return {}; // Return empty if no solution is found
    }
};
