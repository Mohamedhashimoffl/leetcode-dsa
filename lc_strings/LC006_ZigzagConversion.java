// LeetCode Problem: 6. Zigzag Conversion
// Link: https://leetcode.com/problems/zigzag-conversion/
// Difficulty: Medium
// Tags: String, Simulation
// Time Complexity: O(n), where n is the length of the input string
// Space Complexity: O(n), for storing the result in StringBuilders

class Solution {
    public String convert(String s, int numRows) {
        // Create StringBuilder for each row
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        char[] arr = s.toCharArray();
        int n = arr.length;
        int index = 0;

        // Traverse in zigzag pattern
        while (index < n) {
            // Go down the rows
            for (int j = 0; j < numRows && index < n; j++) {
                sbs[j].append(arr[index++]);
            }
            // Go up diagonally (excluding first and last row)
            for (int j = numRows - 2; j > 0 && index < n; j--) {
                sbs[j].append(arr[index++]);
            }
        }

        // Combine all rows
        StringBuilder res = sbs[0];
        for (int i = 1; i < numRows; i++) {
            res.append(sbs[i].toString());
        }

        return res.toString();
    }
}
