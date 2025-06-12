// LeetCode Problem: 73. Set Matrix Zeroes
// Link: https://leetcode.com/problems/set-matrix-zeroes/
// Difficulty: Medium
// Tags: Matrix, In-place, Two Pointers
// Time Complexity: O(n*m)
// Space Complexity: O(1)

class Solution {
public:
    vector<vector<int>> setZeroes(vector<vector<int>>& matrix) {
        int col0 = 1;
        int n = matrix.size();
        int m = matrix[0].size();

        // Mark rows and columns that need to be zeroed
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        // Update the matrix except first row and first column
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // Handle first row if needed
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Handle first column if needed
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        return matrix;
    }
};
