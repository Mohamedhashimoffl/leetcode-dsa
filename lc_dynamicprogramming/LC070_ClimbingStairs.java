// LeetCode Problem: 70. Climbing Stairs
// Link: https://leetcode.com/problems/climbing-stairs/
// Difficulty: Easy
// Tags: Dynamic Programming
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int onestepbefore = 2;
        int twostepbefore = 1;
        int allways = 0;

        for (int i = 3; i <= n; i++) {
            allways = onestepbefore + twostepbefore;
            twostepbefore = onestepbefore;
            onestepbefore = allways;
        }
        return allways;
    }
}
