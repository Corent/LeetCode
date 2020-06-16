package com.sven.algorithm687;

public class Algorithm687 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    private int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        longestUnivaluePathCore(root);
        return ans;
    }

    private void longestUnivaluePathCore(TreeNode root) {
        if (root == null) return;
        int path = 0;
        if (root.left != null && root.val == root.left.val) path += 1 + findUnivaluePath(root.left);
        if (root.right != null && root.val == root.right.val) path += 1 + findUnivaluePath(root.right);
        ans = Math.max(ans, path);
        if (root.left != null) longestUnivaluePathCore(root.left);
        if (root.right != null) longestUnivaluePathCore(root.right);
    }

    private int findUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int leftPath = root.left != null && root.left.val == root.val ? 1 + findUnivaluePath(root.left) : 0;
        int rightPath = root.right != null && root.right.val == root.val ? 1 + findUnivaluePath(root.right) : 0;
        return Math.max(leftPath, rightPath);
    }
}