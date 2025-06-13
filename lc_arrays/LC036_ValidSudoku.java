//  LeetCode Problem: 36. Valid Sudoku
//  Link: https://leetcode.com/problems/valid-sudoku/
//  Difficulty: Medium
//  Tags: Array, Hash Table, Matrix
//  Approach: Use boolean[][] arrays to track seen numbers in rows, cols, and 3x3 boxes
//  Time Complexity: O(1) – Fixed 81 cells
//  Space Complexity: O(1) – Fixed 3 * (9x10) = 270 booleans
// ------------------------------------------------------------

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // seen[row][number] = true if number seen in row
        boolean[][] rowSeen = new boolean[9][10]; 
        // seen[col][number] = true if number seen in column
        boolean[][] colSeen = new boolean[9][10]; 
        // seen[region][number] = true if number seen in 3x3 region
        boolean[][] regionSeen = new boolean[9][10]; 

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char cell = board[row][col];

                if (cell == '.') {
                    continue;
                }

                int num = cell - '0'; // Convert char '1'-'9' to int 1-9

                // Calculate region index
                int regionIndex = (row / 3) * 3 + (col / 3);

                if (rowSeen[row][num] || colSeen[col][num] || regionSeen[regionIndex][num]) {
                    return false; // Duplicate found
                }

                rowSeen[row][num] = true;
                colSeen[col][num] = true;
                regionSeen[regionIndex][num] = true;
            }
        }
        return true;
    }
}
