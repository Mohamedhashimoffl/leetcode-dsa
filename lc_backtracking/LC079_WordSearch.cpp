// LeetCode Problem: 79. Word Search
// Link: https://leetcode.com/problems/word-search/
// Difficulty: Medium
// Tags: Array, Backtracking, Matrix
// Time Complexity: O(m * n * 4^L), where m*n is board size and L is word length
// Space Complexity: O(L) for recursion stack

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        int rows = board.size();
        int cols = board[0].size();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

private:
    bool dfs(vector<vector<char>>& board, const string& word, int index, int row, int col) {
        if (index == word.size()) return true;

        if (row < 0 || col < 0 || row >= board.size() || col >= board[0].size() || board[row][col] != word[index])
            return false;

        char temp = board[row][col];
        board[row][col] = '#';  // mark as visited

        bool found = dfs(board, word, index + 1, row + 1, col) ||
                     dfs(board, word, index + 1, row - 1, col) ||
                     dfs(board, word, index + 1, row, col + 1) ||
                     dfs(board, word, index + 1, row, col - 1);

        board[row][col] = temp;  // restore original value
        return found;
    }
};
