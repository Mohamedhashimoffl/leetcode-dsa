// LeetCode Problem: 14. Longest Common Prefix
// https://leetcode.com/problems/longest-common-prefix/
// Difficulty: Easy
// Tags: Strings, Array, Prefix
// Time Complexity: O(S), where S = total number of characters in all strings
// Space Complexity: O(1)

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}
