// Problem: 3442. Maximum Difference Between Even and Odd Frequency I
// Link: https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/
// Difficulty: Easy
// Tags: String, Frequency Count, Math
// Time Complexity: O(n) – where n is the length of the string
// Space Complexity: O(1) – fixed size frequency array

class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxodd = 0;
        int mineven = Integer.MAX_VALUE;

        for (int f : freq) {
            if (f == 0) continue;
            if (f % 2 == 1) {
                maxodd = Math.max(maxodd, f);
            } else {
                mineven = Math.min(mineven, f);
            }
        }

        if (maxodd == 0 || mineven == Integer.MAX_VALUE) return 0;
        return maxodd - mineven;
    }
}
