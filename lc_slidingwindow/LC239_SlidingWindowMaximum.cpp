// LeetCode Problem: 239. Sliding Window Maximum
// Link: https://leetcode.com/problems/sliding-window-maximum/
// Difficulty: Hard
// Tags: Array, Heap (Priority Queue), Sliding Window, Monotonic Queue
// Time Complexity: O(n), where n is the number of elements in nums
// Space Complexity: O(k), for the deque storing indices within the window

class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        deque<int> dq;  // Stores indices of useful elements in current window
        vector<int> ans;

        for (int i = 0; i < nums.size(); i++) {
            // Remove indices out of the current window
            if (!dq.empty() && dq.front() == i - k)
                dq.pop_front();

            // Remove all smaller elements as they are not useful
            while (!dq.empty() && nums[dq.back()] < nums[i])
                dq.pop_back();

            dq.push_back(i);

            // Starting from i = k - 1, add max in window to result
            if (i >= k - 1)
                ans.push_back(nums[dq.front()]);
        }

        return ans;
    }
};
