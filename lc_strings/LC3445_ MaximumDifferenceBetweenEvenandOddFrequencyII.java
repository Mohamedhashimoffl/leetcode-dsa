// Problem: 3445. Maximum Difference Between Even and Odd Frequency II
// Link: https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-ii/
// Difficulty: Hard
// Tags: Sliding Window, Frequency Count, String, Math
// Time Complexity: O(1) * O(n) = O(n) – (since fixed range '0'-'4' = 5 characters, two nested loops = constant)
// Space Complexity: O(1) – fixed frequency tracking arrays

class Solution {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int maxdiff = Integer.MIN_VALUE;

        for (char a = '0'; a <= '4'; a++) {
            for (char b = '0'; b <= '4'; b++) {
                if (a == b) continue;

                int counta = 0, countb = 0;
                int[] mindiff = new int[4];
                Arrays.fill(mindiff, Integer.MAX_VALUE);

                int left = 0, preva = 0, prevb = 0;

                for (int right = 0; right < n; right++) {
                    if (s.charAt(right) == a) counta++;
                    if (s.charAt(right) == b) countb++;

                    while (right - left + 1 >= k && (counta - preva > 0) && (countb - prevb > 0)) {
                        int pa = preva % 2, pb = prevb % 2;
                        int index = 2 * pa + pb;
                        mindiff[index] = Math.min(mindiff[index], preva - prevb);

                        if (s.charAt(left) == a) preva++;
                        if (s.charAt(left) == b) prevb++;
                        left++;
                    }

                    int paritya = counta % 2, parityb = countb % 2;
                    int checkIndex = 2 * (1 - paritya) + parityb;

                    if (mindiff[checkIndex] != Integer.MAX_VALUE) {
                        int candidate = (counta - countb) - mindiff[checkIndex];
                        maxdiff = Math.max(maxdiff, candidate);
                    }
                }
            }
        }
        return maxdiff == Integer.MIN_VALUE ? -1 : maxdiff;
    }
}
