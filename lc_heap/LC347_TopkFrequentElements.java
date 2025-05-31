// LeetCode Problem: 347. Top K Frequent Elements
// Link: https://leetcode.com/problems/top-k-frequent-elements/
// Tags: Hash Table, Heap, Sorting
// Time Complexity: O(N log N) due to sorting
// Space Complexity: O(N)

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(freq.keySet());
        Collections.sort(list, (a, b) -> freq.get(b) - freq.get(a));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
