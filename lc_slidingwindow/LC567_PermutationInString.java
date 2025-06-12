// Problem: 567. Permutation in String
// Link: https://leetcode.com/problems/permutation-in-string/
// Difficulty: Medium
// Tags: Sliding Window, Two Pointers, String, Hashing
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1count = new int[26];
        int[] s2count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (Arrays.equals(s1count, s2count)) return true;

            if (i + s1.length() < s2.length()) {
                s2count[s2.charAt(i) - 'a']--;
                s2count[s2.charAt(i + s1.length()) - 'a']++;
            }
        }

        return false;
    }
}
