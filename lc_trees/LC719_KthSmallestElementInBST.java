// LeetCode Problem 230: Kth Smallest Element in a BST
// Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// Tags: Tree, Binary Search Tree, Stack, DFS (Inorder Traversal)
// Time Complexity: O(H + k), where H is the height of the tree
// Space Complexity: O(H), for the recursion stack or explicit stack used

public class KthSmallestElementInBST {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Solution {
        public int kthSmallest(TreeNode root, int k) {
            if(root == null) return -1;
            int count = 0;
            java.util.Stack<TreeNode> stack = new java.util.Stack<>();

            while(root != null || !stack.isEmpty()) {
                while(root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                count++;
                if(count == k) return root.val;
                root = root.right;
            }
            return -1;
        }
    }
}
