// LC40. Combination Sum II
// LeetCode Problem: 40. Combination Sum II
// Link: https://leetcode.com/problems/combination-sum-ii/
// Tags: Array, Backtracking
// Difficulty: Medium
// Time Complexity: O(2^n), where n = number of candidates
// Space Complexity: O(k * x), where x = number of valid combinations and k = average length

class Solution {
    static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
