// LeetCode Problem: 66. Plus One
// Link: https://leetcode.com/problems/plus-one/
// Tags: Array
// Time Complexity: O(n)
// Space Complexity: O(1)

#include <vector>

using namespace std;

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int n = digits.size();

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // If all digits were 9, insert 1 at the beginning
        digits.insert(digits.begin(), 1);
        return digits;
    }
};
