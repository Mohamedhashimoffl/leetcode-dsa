// 2616. Minimize the Maximum Difference of Pairs
// https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/
// Difficulty: Medium
// Tags: Binary Search, Greedy, Sorting
// Time Complexity: O(n log(maxDiff)) where n = nums.length
// Space Complexity: O(1)

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums); // Sort the array first

        int left = 0, right = nums[nums.length - 1] - nums[0]; // Max possible diff

        while (left < right) {
            int mid = (left + right) / 2;
            if (canFormPairs(nums, mid, p)) {
                right = mid; // Try to minimize further
            } else {
                left = mid + 1; // Need larger max diff
            }
        }

        return left;
    }

    // Greedy check: can we form at least p pairs with max diff ≤ mid?
    private boolean canFormPairs(int[] nums, int maxDiff, int p) {
        int count = 0;
        for (int i = 1; i < nums.length && count < p; ) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i += 2; // skip both used elements
            } else {
                i++;
            }
        }
        return count >= p;
    }
}
