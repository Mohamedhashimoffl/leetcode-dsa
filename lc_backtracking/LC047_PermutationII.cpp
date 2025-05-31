// LeetCode Problem: 47. Permutations II
// Link: https://leetcode.com/problems/permutations-ii/
// Difficulty: Medium

// Tags: Backtracking, Sorting, Permutations
// Time Complexity: O(n! * n) due to generating permutations and copying results
// Space Complexity: O(n) for recursion stack and output storage

class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> result;
        do {
            result.push_back(nums);
        } while (next_permutation(nums.begin(), nums.end()));
        return result;
    }
};
