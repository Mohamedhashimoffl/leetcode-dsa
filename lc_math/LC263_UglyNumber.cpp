// LeetCode Problem: 263. Ugly Number
// Link: https://leetcode.com/problems/ugly-number/
// Difficulty: Easy

// Tags: Math
// Time Complexity: O(log n) – because we keep dividing n by 2, 3, and 5
// Space Complexity: O(1)

class Solution {
public:
    bool isUgly(int n) {
        if (n <= 0) return false;

        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;

        return n == 1;
    }
};
