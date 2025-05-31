// LeetCode Problem: 1482. Minimum Number of Days to Make m Bouquets
// Link: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
// Difficulty: Medium

// Tags: Binary Search, Greedy, Array
// Time Complexity: O(n * log(max_day)) where n = size of bloomDay, and max_day is the range between min and max bloom days
// Space Complexity: O(1) – only constant extra space used

class Solution {
public:
    bool possible(vector<int>& bloomDay, int day, int m, int k) {
        int count = 0, bouquets = 0;
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        return bouquets >= m;
    }

    int minDays(vector<int>& bloomDay, int m, int k) {
        long long totalFlowers = 1LL * m * k;
        if (totalFlowers > bloomDay.size()) return -1;

        int low = *min_element(bloomDay.begin(), bloomDay.end());
        int high = *max_element(bloomDay.begin(), bloomDay.end());

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
};
