// LeetCode Problem: 31. Next Permutation
// Link: https://leetcode.com/problems/next-permutation/
// Tags: Array, Two Pointers
// Time Complexity: O(n)
// Space Complexity: O(1)

#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        // STL method does everything in-place
        next_permutation(nums.begin(), nums.end());
    }
};
