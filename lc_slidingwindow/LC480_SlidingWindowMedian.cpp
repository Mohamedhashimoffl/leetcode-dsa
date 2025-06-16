/*
Leetcode Problem 480: Sliding Window Median
Link: https://leetcode.com/problems/sliding-window-median/
Difficulty: Hard
Tags: Heap, Sliding Window, Priority Queue, Multiset, Two Heaps, Lazy Deletion
Time Complexity: O(n log k) — insertion and deletion from heaps take O(log k)
Space Complexity: O(k) — for the heaps and the delayed map
*/

class Solution {
public:
    vector<double> medianSlidingWindow(vector<int>& nums, int k) {
        vector<double> result;

        // MaxHeap for the left half
        priority_queue<int> maxHeap;

        // MinHeap for the right half
        priority_queue<int, vector<int>, greater<int>> minHeap;

        // Delayed deletions
        unordered_map<int, int> delayed;

        int maxSize = 0, minSize = 0;

        // Remove top elements that are marked for delayed deletion
        auto prune = [&](auto& heap, bool isMax) {
            while (!heap.empty()) {
                int num = heap.top();
                if (delayed.count(num)) {
                    if (--delayed[num] == 0) delayed.erase(num);
                    heap.pop();
                } else break;
            }
        };

        // Maintain size balance between heaps
        auto balance = [&]() {
            if (maxSize > minSize + 1) {
                minHeap.push(maxHeap.top());
                maxHeap.pop(); maxSize--; minSize++;
                prune(maxHeap, true);
            } else if (maxSize < minSize) {
                maxHeap.push(minHeap.top());
                minHeap.pop(); minSize--; maxSize++;
                prune(minHeap, false);
            }
        };

        for (int i = 0; i < nums.size(); ++i) {
            int num = nums[i];

            // Add the new element
            if (maxHeap.empty() || num <= maxHeap.top()) {
                maxHeap.push(num); maxSize++;
            } else {
                minHeap.push(num); minSize++;
            }
            balance();

            // If window exceeded size k, remove the outgoing element
            if (i >= k) {
                int out = nums[i - k];
                delayed[out]++;
                if (out <= maxHeap.top()) maxSize--;
                else minSize--;
                prune(maxHeap, true);
                prune(minHeap, false);
                balance();
            }

            // If window size is k, compute the median
            if (i >= k - 1) {
                if (k % 2 == 1) {
                    result.push_back(maxHeap.top());
                } else {
                    result.push_back(((double)maxHeap.top() + minHeap.top()) / 2.0);
                }
            }
        }

        return result;
    }
};
