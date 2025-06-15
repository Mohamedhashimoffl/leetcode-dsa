// LeetCode Problem: 1432. Max Difference You Can Get From Changing an Integer
// Link: https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/
// Difficulty: Medium
// Tags: Greedy, Math
// Time Complexity: O(n), where n is the number of digits in the number
// Space Complexity: O(n), for string operations

class Solution {
    public int maxDiff(int num) {
        String original = Integer.toString(num);

        // Create max string by replacing the first non-9 digit with 9
        String maxstr = original;
        for (int i = 0; i < maxstr.length(); i++) {
            if (maxstr.charAt(i) != '9') {
                maxstr = maxstr.replace(maxstr.charAt(i), '9');
                break;
            }
        }

        // Create min string:
        // - If first digit != '1', replace it with '1'
        // - Else, replace first non-0/1 digit with '0'
        String minstr = original;
        char firstchar = minstr.charAt(0);
        if (firstchar != '1') {
            minstr = minstr.replace(firstchar, '1');
        } else {
            for (int i = 1; i < minstr.length(); i++) {
                if (minstr.charAt(i) != '0' && minstr.charAt(i) != '1') {
                    minstr = minstr.replace(minstr.charAt(i), '0');
                    break;
                }
            }
        }

        return Integer.parseInt(maxstr) - Integer.parseInt(minstr);
    }
}
