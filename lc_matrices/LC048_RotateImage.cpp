// LeetCode Problem: 48. Rotate Image
// Link: https://leetcode.com/problems/rotate-image/
// Difficulty: Medium
// Tags: Array, Math, Matrix
// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();

        // Transpose the matrix
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix[i][j], matrix[j][i]);
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            reverse(matrix[i].begin(), matrix[i].end());
        }
    }
};
