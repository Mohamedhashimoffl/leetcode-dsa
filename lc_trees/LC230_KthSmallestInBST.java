// LeetCode Problem: 230. Kth Smallest Element in a BST
// Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// Difficulty: Medium
// Tags: Binary Search Tree, Stack, Inorder Traversal
// Time Complexity: O(H + k), where H is the tree height
// Space Complexity: O(H), recursion stack or explicit stack size

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class LC230_KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;

        int count = 0;
        Stack<TreeNode> stack = new Stack<>();

        // Inorder traversal iterative using stack to get elements in ascending order
        while (root != null || !stack.isEmpty()) {
            // Go as left as possible
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // Pop the node from stack and increment count
            root = stack.pop();
            count++;

            // If count matches k, return the current node's value
            if (count == k) return root.val;

            // Move to right subtree
            root = root.right;
        }

        // If k is more than total nodes, return -1 (or could throw exception)
        return -1;
    }
}
