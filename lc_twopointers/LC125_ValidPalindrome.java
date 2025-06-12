// LeetCode Problem: 125. Valid Palindrome
// Link: https://leetcode.com/problems/valid-palindrome/
// Difficulty: Easy
// Tags: Two Pointers, String
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Move left pointer if current char is not alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move right pointer if current char is not alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // Compare characters in a case-insensitive manner
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
