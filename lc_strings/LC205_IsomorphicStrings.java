// LeetCode Problem: 205. Isomorphic Strings
// Link: https://leetcode.com/problems/isomorphic-strings/
// Difficulty: Easy
// Tags: Hash Table, String
// Time Complexity: O(n), where n is the length of the strings
// Space Complexity: O(1), constant size arrays used

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (mapS[sc] != mapT[tc]) return false;

            mapS[sc] = i + 1;
            mapT[tc] = i + 1;
        }

        return true;
    }
}
