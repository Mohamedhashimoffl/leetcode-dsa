// LeetCode Problem: 9. Palindrome Number
// Link: https://leetcode.com/problems/palindrome-number/
// Difficulty: Easy
// Tags: Math, Integer Manipulation
// Time Complexity: O(log₁₀n) — number of digits in x
// Space Complexity: O(1)

#include <climits> // For LLONG_MAX

class Solution {
public:
    bool isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) return false;

        int original = x;
        long long reversed = 0;

        while (x != 0) {
            int digit = x % 10;

            // Check for overflow (though unnecessary for 32-bit int inputs in LeetCode)
            if (reversed > (LLONG_MAX - digit) / 10)
                return false;

            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return original == reversed;
    }
};
