// LeetCode Problem: 131. Palindrome Partitioning
// Link: https://leetcode.com/problems/palindrome-partitioning/
// Difficulty: Medium
// Tags: Backtracking, Dynamic Programming, String
// Time Complexity: O(n * 2^n) — each substring decision leads to 2 branches (partition or not), with DP optimization for palindromes
// Space Complexity: O(n^2) for the DP table + O(n) recursion depth

import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        boolean[][] isPalindrome = new boolean[n][n];

        // Preprocess palindrome substrings using DP
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) &&
                    (end - start <= 2 || isPalindrome[start + 1][end - 1])) {
                    isPalindrome[start][end] = true;
                }
            }
        }

        backtrack(s, 0, new ArrayList<>(), res, isPalindrome);
        return res;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> res, boolean[][] isPalindrome) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome[start][end]) {
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, path, res, isPalindrome);
                path.remove(path.size() - 1);
            }
        }
    }
}
