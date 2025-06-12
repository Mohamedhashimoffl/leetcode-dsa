// Problem: 141. Linked List Cycle
// Link: https://leetcode.com/problems/linked-list-cycle/
// Difficulty: Easy
// Tags: Linked List, Two Pointers, Floyd's Cycle Detection
// Time Complexity: O(n)
// Space Complexity: O(1)

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        // 🔹 Edge Case Handling:
        // If the list is empty or has only one node, no cycle is possible.
        if (head == null || head.next == null) return false;

        // 🔹 Initialization:
        // Slow pointer moves 1 step, fast pointer moves 2 steps.
        ListNode slow = head;
        ListNode fast = head.next;

        // 🔹 Floyd's Cycle Detection Loop:
        // If a cycle exists, slow and fast will eventually meet.
        while (slow != fast) {
            // 🔹 End of List Check:
            // If fast or fast.next is null, the list has no cycle.
            if (fast == null || fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }

        // 🔹 Cycle Detected:
        return true;
    }
}
