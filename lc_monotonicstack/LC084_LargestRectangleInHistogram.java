// Problem: 84. Largest Rectangle in Histogram
// Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
// Difficulty: Hard
// Tags: Array, Stack, Monotonic Stack
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];  // Handle end by inserting 0
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
