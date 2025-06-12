// LeetCode Problem: 5. Longest Palindromic Substring
// Link: https://leetcode.com/problems/longest-palindromic-substring/
// Difficulty: Medium
// Tags: String, Dynamic Programming, Expand Around Center
// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCentre(s, i, i);
            int len2 = expandFromCentre(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandFromCentre(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
