// LeetCode Problem: 443. String Compression
// Link: https://leetcode.com/problems/string-compression/
// Difficulty: Medium
// Tags: Two Pointers, String, In-place
// Time Complexity: O(n)
// Space Complexity: O(1)

#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    int compress(vector<char>& chars) {
        int index = 0; // Position to write compressed chars
        int i = 0;     // Read pointer

        while (i < (int)chars.size()) {
            char currentchar = chars[i];
            int count = 0;
            chars[index++] = currentchar;

            // Count occurrences of currentchar
            while (i < (int)chars.size() && chars[i] == currentchar) {
                i++;
                count++;
            }

            // Write count if more than 1
            if (count > 1) {
                string countstr = to_string(count);
                for (char c : countstr) {
                    chars[index++] = c;
                }
            }
        }
        return index;
    }
};
