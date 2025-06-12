// LeetCode Problem: 46. Permutations
// Link: https://leetcode.com/problems/permutations/
// Difficulty: Medium
// Tags: Backtracking, Sorting, Permutations
// Time Complexity: O(n! * n) — n! permutations, each copied in O(n)
// Space Complexity: O(n!) for output only (no recursion used)

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
