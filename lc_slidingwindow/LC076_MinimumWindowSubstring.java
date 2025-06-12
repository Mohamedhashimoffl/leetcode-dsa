// LeetCode Problem: 76. Minimum Window Substring
// Link: https://leetcode.com/problems/minimum-window-substring/
// Difficulty: Hard
// Tags: Hash Table, String, Sliding Window
// Time Complexity: O(s.length + t.length)
// Space Complexity: O(t.length)

import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> req = new HashMap<>();
        for (char c : t.toCharArray()) {
            req.put(c, req.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, minStrt = 0;
        int minLen = Integer.MAX_VALUE;
        int count = t.length();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (req.containsKey(c)) {
                if (req.get(c) > 0) count--;
                req.put(c, req.get(c) - 1);
            }
            right++;

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStrt = left;
                }
                char leftchar = s.charAt(left);
                if (req.containsKey(leftchar)) {
                    req.put(leftchar, req.get(leftchar) + 1);
                    if (req.get(leftchar) > 0) count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStrt, minStrt + minLen);
    }
}
