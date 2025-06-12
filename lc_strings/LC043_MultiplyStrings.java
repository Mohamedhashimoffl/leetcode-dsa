// LeetCode Problem: 43. Multiply Strings
// Link: https://leetcode.com/problems/multiply-strings/
// Difficulty: Medium
// Tags: Math, String, Simulation
// Time Complexity: O(m * n), where m and n are the lengths of num1 and num2
// Space Complexity: O(m + n), for the result array

class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                int mul = d1 * d2;
                int p1 = i + j, p2 = i + j + 1;

                int sum = mul + result[p2];
                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
