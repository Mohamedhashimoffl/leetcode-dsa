// LeetCode Problem: 12. Integer to Roman
// Link: https://leetcode.com/problems/integer-to-roman/
// Tags: Math, String, Greedy
// Time Complexity: O(1) – Since the value range is fixed (1 to 3999)
// Space Complexity: O(1)

import java.util.*;

public class LC012_IntegerToRoman {
    public String intToRoman(int num) {
        // Map fixed values to Roman numerals
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        // Sorted values in descending order
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();

        for (int value : values) {
            while (num >= value) {
                result.append(map.get(value));
                num -= value;
            }
        }

        return result.toString();
    }
}
