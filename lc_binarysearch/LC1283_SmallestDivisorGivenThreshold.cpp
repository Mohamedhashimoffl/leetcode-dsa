// LeetCode Problem: 1283. Find the Smallest Divisor Given a Threshold
// Link: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
// Difficulty: Medium
// Tags: Binary Search
// Time Complexity: O(n * log(max(nums)))
// Space Complexity: O(1)

class Solution {
public:
    int sumBy(vector<int>& nums, int div) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + div - 1) / div; // Equivalent to ceil(num / div)
        }
        return sum;
    }

    int smallestDivisor(vector<int>& nums, int threshold) {
        int low = 1, high = *max_element(nums.begin(), nums.end());
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sumBy(nums, mid) <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
};
