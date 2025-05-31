// LeetCode Problem: 56. Merge Intervals
// Link: https://leetcode.com/problems/merge-intervals/
// Difficulty: Medium

// Tags: Array, Sorting, Intervals
// Time Complexity: O(n log n) due to sorting intervals
// Space Complexity: O(n) for output storage in worst case

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> res;
        sort(intervals.begin(), intervals.end());
        for (int i = 0; i < intervals.size(); i++) {
            if (res.empty() || res.back()[1] < intervals[i][0]) {
                res.push_back(intervals[i]);
            } else {
                res.back()[1] = max(res.back()[1], intervals[i][1]);
            }
        }
        return res;
    }
};
