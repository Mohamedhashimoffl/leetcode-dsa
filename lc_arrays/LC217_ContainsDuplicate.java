// Problem: 217. Contains Duplicate
// Link: https://leetcode.com/problems/contains-duplicate/
// Difficulty: Easy
// Tags: Array, Hash Table, Set
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) return true;  // Duplicate found
            seen.add(num);                        // Add to set
        }
        return false;  // No duplicates
    }
}
