// LeetCode Problem: 143. Reorder List
// Link: https://leetcode.com/problems/reorder-list/
// Difficulty: Medium
// Tags: Linked List, Two Pointers, Recursion
// Time Complexity: O(n)
// Space Complexity: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        // Step 1: Find middle of the list
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half of the list
        ListNode second = reverse(slow.next);
        slow.next = null;  // cut the list into two halves

        // Step 3: Merge two halves alternating nodes
        ListNode first = head;
        while(second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
