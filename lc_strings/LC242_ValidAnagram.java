// LeetCode Problem: 242. Valid Anagram
// Link: https://leetcode.com/problems/valid-anagram/
// Difficulty: Easy
// Tags: Hash Table, String
// Time Complexity: O(n)
// Space Complexity: O(1)

class ValidAnagramSolution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) count[c - 'a']++;
        for(char c : t.toCharArray()) count[c - 'a']--;
        for(int x : count) {
            if(x != 0)
                return false;
        }
        return true;
    }
}
