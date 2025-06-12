// LeetCode Problem: 3. Longest Substring Without Repeating Characters
// Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Difficulty: Medium
// Tags: Sliding Window, HashMap, String
// Time Complexity: O(n) where n = length of input string
// Space Complexity: O(min(m, n)) where m = size of charset (e.g., 128 for ASCII)

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < n) {
            char ch = s.charAt(right);

            // If character is already in map, move left pointer
            if (map.containsKey(ch)) {
                left = Math.max(map.get(ch) + 1, left);
            }

            // Update or add character index
            map.put(ch, right);

            // Calculate max length so far
            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }
        return maxLen;
    }
}
