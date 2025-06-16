/*
Leetcode Problem 290: Word Pattern
Link: https://leetcode.com/problems/word-pattern/
Difficulty: Easy
Tags: Hashing, String, Map, Bijection
Time Complexity: O(n) — where n is number of words in the string
Space Complexity: O(n) — for storing word mappings
*/

class Solution {
public:
    bool wordPattern(string pattern, string s) {
        vector<string> words;
        istringstream ss(s); // Used to split string by space
        string word;

        // Split the input string `s` into words
        while (ss >> word)
            words.push_back(word);

        // Pattern and word list must be same size
        if (words.size() != pattern.size())
            return false;

        // charToWord maps pattern character ('a' to 'z') to words
        string charToWord[26];

        // wordToChar ensures no two pattern chars map to the same word
        map<string, char> wordToChar;

        for (int i = 0; i < pattern.size(); ++i) {
            char c = pattern[i];
            string w = words[i];
            int index = c - 'a';

            // If this character and word are new, bind them
            if (charToWord[index].empty() && wordToChar.count(w) == 0) {
                charToWord[index] = w;
                wordToChar[w] = c;
            }
            // If there's a mismatch in mapping, return false
            else if (charToWord[index] != w || wordToChar[w] != c) {
                return false;
            }
        }

        return true;
    }
};
