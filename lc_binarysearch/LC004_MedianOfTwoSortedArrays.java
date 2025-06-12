// Problem: 4. Median of Two Sorted Arrays
// Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
// Difficulty: Hard
// Tags: Array, Binary Search, Divide and Conquer, Sorting
// Time Complexity: O(log(min(m, n)))
// Space Complexity: O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 🔹 Preprocessing / Input Normalization:
        // Always binary search on the smaller array to keep time complexity minimal.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // 🔹 Initialization / Setup:
        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;

        // 🔹 Binary Search Loop:
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            // 🔹 Partition Edge Handling:
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            // 🔹 Median Calculation:
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // Even length total
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } 
                // Odd length total
                else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } 
            // 🔹 Binary Search Range Adjustment:
            else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        // 🔹 Fallback / Error Handling:
        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }
}
