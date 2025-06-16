/*
Leetcode Problem 2016: Maximum Difference Between Increasing Elements
Link: https://leetcode.com/problems/maximum-difference-between-increasing-elements/
Difficulty: Easy
Tags: Array, Prefix Minimum, One Pass
Time Complexity: O(n) — single traversal through the array
Space Complexity: O(1) — only constant extra space used
*/

class Solution {
public:
    int maximumDifference(vector<int>& nums) {
        int minVal = nums[0];       // Initialize with the first element
        int maxdiff = -1;           // Default answer if no valid pair exists

        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] > minVal) {
                // A valid increasing pair found
                maxdiff = max(maxdiff, nums[i] - minVal);
            } else {
                // Update minVal if a smaller number is found
                minVal = nums[i];
            }
        }

        return maxdiff;
    }
};
