// Problem: 33. Search in Rotated Sorted Array
// Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
// Difficulty: Medium
// Tags: Array, Binary Search
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int a = nums.size();
        int low = 0, high = a - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) return mid;

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
};
