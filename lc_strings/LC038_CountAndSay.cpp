// LeetCode Problem: 38. Count and Say
// Link: https://leetcode.com/problems/count-and-say/
// Tags: String, Simulation
// Time Complexity: O(n * m) where m is the length of the generated string at step n
// Space Complexity: O(m)

#include <string>
#include <sstream>

using namespace std;

class Solution {
public:
    string countAndSay(int n) {
        if (n == 1) return "1";
        string currentstring = "1";

        for (int k = 1; k < n; k++) {
            stringstream storingans;
            int count = 1;

            for (int i = 1; i <= (int)currentstring.length(); i++) {
                if (i < (int)currentstring.length() && currentstring[i] == currentstring[i - 1]) {
                    count++;
                } else {
                    storingans << count << currentstring[i - 1];
                    count = 1;
                }
            }
            currentstring = storingans.str();
        }
        return currentstring;
    }
};
