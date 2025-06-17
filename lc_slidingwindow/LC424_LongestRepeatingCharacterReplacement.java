/*
LeetCode Problem 424: Longest Repeating Character Replacement
Link: https://leetcode.com/problems/longest-repeating-character-replacement/
Difficulty: Medium
Tags: Sliding Window, String, Two Pointers
Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxcount = 0, maxlength = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxcount = Math.max(maxcount, count[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxcount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxlength = Math.max(maxlength, right - left + 1);
        }
        return maxlength;
    }
}
