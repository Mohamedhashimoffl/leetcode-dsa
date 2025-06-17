/*
LeetCode Problem 3405: Count the Number of Arrays with K Matching Adjacent Elements
Link: https://leetcode.com/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements/
Difficulty: Hard
Tags: Dynamic Programming, Combinatorics, Math, Binomial Coefficient, Modular Arithmetic
Time Complexity: O(k + log n) 
Space Complexity: O(1)
*/

class Solution {
    private static final int MOD = 1000000007;

    // Fast exponentiation (modular power)
    private long power(long x, long y) {
        long result = 1;
        x = x % MOD;
        while (y > 0) {
            if ((y & 1) == 1)
                result = (result * x) % MOD;
            x = (x * x) % MOD;
            y >>= 1;
        }
        return result;
    }

    // Modular Inverse using Fermat's little theorem
    private long modInverse(long a) {
        return power(a, MOD - 2);
    }

    // Compute nCr % MOD
    private long nCr(long n, long r) {
        if (r > n) return 0;
        if (r == 0) return 1;
        long num = 1, den = 1;
        for (long i = 0; i < r; i++) {
            num = (num * (n - i)) % MOD;
            den = (den * (i + 1)) % MOD;
        }
        return (num * modInverse(den)) % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        if (k >= n) return 0;

        long kPos = nCr(n - 1, k); // Choose k positions among (n-1) adjacent pairs
        long rem = power(m - 1, n - k - 1); // Remaining positions have (m-1) choices

        long ans = (kPos * m) % MOD;
        ans = (ans * rem) % MOD;

        return (int) ans;
    }
}
