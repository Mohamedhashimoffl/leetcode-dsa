// LeetCode Problem: 560. Subarray Sum Equals K
// Link: https://leetcode.com/problems/subarray-sum-equals-k/
// Difficulty: Medium
// Tags: Hash Map, Prefix Sum
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1);

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (prefixSumFreq.containsKey(sum - k)) {
                count += prefixSumFreq.getOrDefault(sum - k, 0);
            }
            prefixSumFreq.put(sum, prefixSumFreq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
