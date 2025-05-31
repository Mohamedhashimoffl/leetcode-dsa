// LeetCode Problem: 216. Combination Sum III
// Link: https://leetcode.com/problems/combination-sum-iii/
// Tags: Backtracking
// Time Complexity: O(9 choose k)
// Space Complexity: O(k) for recursion stack

import java.util.*;

public class LC216_CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int k, int target, List<Integer> comb, List<List<Integer>> result) {
        if (target == 0 && comb.size() == k) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > target) break;
            comb.add(i);
            backtrack(i + 1, k, target - i, comb, result);
            comb.remove(comb.size() - 1);
        }
    }
}
