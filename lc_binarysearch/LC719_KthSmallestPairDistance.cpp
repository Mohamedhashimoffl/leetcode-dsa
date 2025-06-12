// LeetCode Problem: 719. Find K-th Smallest Pair Distance
// Link: https://leetcode.com/problems/find-k-th-smallest-pair-distance/
// Difficulty: Hard
// Tags: Array, Two Pointers, Binary Search, Sorting
// Time Complexity: O(n log(max-min)) * O(n)
// Space Complexity: O(1)

#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

class Solution {
public:
    // Counts how many pairs have a distance <= 'diff'
    int sliding(int diff, vector<int>& nums, int n) {
        int count = 0, j = 0;
        for (int i = 1; i < n; i++) {
            while ((nums[i] - nums[j]) > diff) {
                j++;
            }
            count += (i - j);
        }
        return count;
    }

    int smallestDistancePair(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        int n = nums.size();

        int low = 0;
        int high = nums[n - 1] - nums[0];

        while (low < high) {
            int mid = (low + high) / 2;
            int count = sliding(mid, nums, n);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
};
