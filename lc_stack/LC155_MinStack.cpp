// LeetCode Problem: 155. Min Stack
// Link: https://leetcode.com/problems/min-stack/
// Difficulty: Easy
// Tags: Stack, Design
// Time Complexity: O(1) for all operations
// Space Complexity: O(n)

#include <stack>
using namespace std;

class MinStack {
    stack<int> st;
    stack<int> minSt;
public:
    MinStack() = default;  // Use default constructor
    
    void push(int val) {
        st.push(val);
        // Push the new min value or repeat current min
        if (minSt.empty() || val <= minSt.top()) {
            minSt.push(val);
        } else {
            minSt.push(minSt.top());
        }
    }
    
    void pop() {
        if (!st.empty()) {
            st.pop();
            minSt.pop();
        }
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return minSt.top();
    }
};
