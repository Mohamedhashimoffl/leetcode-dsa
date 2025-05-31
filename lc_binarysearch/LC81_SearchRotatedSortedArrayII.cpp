// LeetCode Problem: 81. Search in Rotated Sorted Array II
// Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
// Difficulty: Medium

// Tags: Binary Search, Array, Duplicates
// Time Complexity: O(n) in worst case due to duplicates, average O(log n)
// Space Complexity: O(1)

class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int a = nums.size();
        int low = 0, high = a - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return true;

            // Handle duplicates: shrink the bounds
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            // Left sorted portion
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right sorted portion
            else if (nums[mid] <= nums[high]) {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
};
