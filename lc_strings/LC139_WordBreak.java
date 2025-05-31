// LeetCode Problem: 139. Word Break
// Link: https://leetcode.com/problems/word-break/
// Tags: Dynamic Programming, String, HashSet
// Time Complexity: O(n^2 * m) where n = length of s, m = avg length of words in wordDict (due to substring check)
// Space Complexity: O(n + m) for dp array and hash set storage

import java.util.*;

public class LC139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
