// LeetCode Problem: 2566. Maximum Difference by Remapping a Digit
// Link: https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/
// Difficulty: Easy
// Tags: String, Greedy, Simulation
// Time Complexity: O(n), where n is the number of digits
// Space Complexity: O(n), for string operations

class Solution {
    public int minMaxDifference(int num) {
        // Convert the number to a string for easy digit manipulation
        String n = Integer.toString(num);

        // Step 1: Find first non-9 digit to replace with '9' for max number
        char replacenum = '9';
        for (char c : n.toCharArray()) {
            if (c != '9') {
                replacenum = c;
                break;
            }
        }

        // Replace all occurrences of replacenum with '9' to get max
        String maxstr = (replacenum == ' ') ? n : n.replace(replacenum, '9');
        int max = Integer.parseInt(maxstr);

        // Step 2: Replace all occurrences of first digit with '0' to get min
        String minstr = n.replace(n.charAt(0), '0');
        int min = Integer.parseInt(minstr);

        // Return the absolute difference between max and min
        return max - min;
    }
}
