// LeetCode Problem: 46. Permutations
// Link: https://leetcode.com/problems/permutations/
// Difficulty: Medium

// Tags: Backtracking, Sorting, Permutations
// Time Complexity: O(n! * n) due to generating all permutations and copying results
// Space Complexity: O(n) for recursion stack and output storage

class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> result;
        sort(nums.begin(), nums.end());
        do {
            result.push_back(nums);
        } while (next_permutation(nums.begin(), nums.end()));
        return result;
    }
};
