// LeetCode Problem: 875. Koko Eating Bananas
// Link: https://leetcode.com/problems/koko-eating-bananas/
// Difficulty: Medium

// Tags: Binary Search, Array
// Time Complexity: O(n * log(max_pile)) where n = size of piles, max_pile is the largest element
// Space Complexity: O(1)

class Solution {
public:
    int totalhours(vector<int>& piles, int k) {
        int hours = 0;
        for (int bananas : piles) {
            hours += ceil((double)bananas / k);
        }
        return hours;
    }

    int minEatingSpeed(vector<int>& piles, int h) {
        int left = 1;
        int right = *max_element(piles.begin(), piles.end());
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (totalhours(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
};
