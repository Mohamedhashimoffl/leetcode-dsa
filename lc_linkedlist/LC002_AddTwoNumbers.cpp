// LeetCode Problem: 2. Add Two Numbers
// Link: https://leetcode.com/problems/add-two-numbers/
// Difficulty: Medium
// Tags: Linked List, Math, Simulation
// Time Complexity: O(max(m, n)) where m and n are the lengths of the input lists
// Space Complexity: O(max(m, n)) for the output list

/**
 * Definition for singly-linked list.
 */
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* dummy = new ListNode(0); // Dummy head for result list
        ListNode* curr = dummy;
        int carry = 0;

        while (l1 || l2 || carry) {
            int sum = carry + (l1 ? l1->val : 0) + (l2 ? l2->val : 0);
            carry = sum / 10;
            curr->next = new ListNode(sum % 10);
            curr = curr->next;

            if (l1) l1 = l1->next;
            if (l2) l2 = l2->next;
        }

        return dummy->next;
    }
};
