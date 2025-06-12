// LeetCode Problem: 11. Container With Most Water
// Link: https://leetcode.com/problems/container-with-most-water/
// Difficulty: Medium
// Tags: Two Pointers, Greedy
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxarea = 0;
        while (left < right) {
            int width = right - left;
            int eachcontainerheight = Math.min(height[left], height[right]);
            maxarea = Math.max(maxarea, eachcontainerheight * width);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }
}
