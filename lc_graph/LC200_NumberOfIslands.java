// LeetCode Problem 200: Number of Islands
// Link: https://leetcode.com/problems/number-of-islands/
// Difficulty: Medium
// Tags: Graph, DFS, Matrix Traversal, Flood Fill
// Time Complexity: O(m * n), where m = number of rows, n = number of columns
// Space Complexity: O(m * n) in worst case due to recursion stack

class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans += 1;
                    dfs(grid, i, j);  // Start DFS to mark the entire island
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int i, int j) {
        // Base case: out of bounds or water cell
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0'; // Mark current land cell as visited

        // Explore all 4 directions (up, down, left, right)
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
    }
}
