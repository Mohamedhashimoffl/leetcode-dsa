// LeetCode Problem: 206. Reverse Linked List
// Link: https://leetcode.com/problems/reverse-linked-list/
// Difficulty: Easy
// Tags: Linked List, Recursion, Iteration
// Time Complexity: O(n)
// Space Complexity: O(1)

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* prev = nullptr;
        ListNode* curr = head;

        while (curr != nullptr) {
            ListNode* next = curr->next;  // Save next node
            curr->next = prev;            // Reverse current node's pointer
            prev = curr;                  // Move prev forward
            curr = next;                  // Move curr forward
        }
        return prev;  // New head of the reversed list
    }
};
