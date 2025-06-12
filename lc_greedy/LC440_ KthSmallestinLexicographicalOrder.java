// LeetCode Problem: 440. K-th Smallest in Lexicographical Order
// Link: https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/
// Difficulty: Hard
// Tags: Trie, Depth-First Search, Greedy
// Time Complexity: O(log n * log n) — due to the prefix tree traversal
// Space Complexity: O(1) — iterative approach with constant space

class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1;

        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);

            if (steps <= k) {
                curr = curr + 1;
                k = k - (int) steps;
            } else {
                curr = curr * 10;
                k = k - 1;
            }
        }
        return curr;
    }

    private long countSteps(int n, long curr, long next) {
        long steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1L, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
