// LeetCode Problem: 49. Group Anagrams
// Link: https://leetcode.com/problems/group-anagrams/
// Difficulty: Medium
// Tags: Hash Table, String, Sorting
// Time Complexity: O(N*K) where N is number of strings and K is max string length
// Space Complexity: O(N*K)

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> completeans = new HashMap<>();

        for (String word : strs) {
            int[] count = new int[26];
            for (char chara : word.toCharArray()) {
                count[chara - 'a']++;
            }
            
            // Create a unique key based on character counts
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                ans.append('#');
                ans.append(count[i]);
            }
            String key = ans.toString();

            // Add the word to the corresponding anagram group
            completeans.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(completeans.values());
    }
}
