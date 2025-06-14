// LeetCode Problem: 39. Combination Sum
// Link: https://leetcode.com/problems/combination-sum/
// Tags: Array, Backtracking
// Difficulty: Medium
// Time Complexity: O(2^t * k), where t = target and k = average length of combinations
// Space Complexity: O(k * x), where x = number of valid combinations


class Solution {
    static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }

        findCombinations(ind + 1, arr, target, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
