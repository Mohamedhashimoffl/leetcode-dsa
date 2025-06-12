// LeetCode Problem: 240. Search a 2D Matrix II
// Link: https://leetcode.com/problems/search-a-2d-matrix-ii/
// Difficulty: Medium
// Tags: Binary Search, Matrix, Two Pointers
// Time Complexity: O(n + m) where n = number of rows, m = number of columns
// Space Complexity: O(1)

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n = matrix.size();
        int m = matrix[0].size();
        int row = 0, col = m - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] == target) 
                return true;
            else if (matrix[row][col] < target) 
                row++;
            else 
                col--;
        }
        return false;
    }
};
