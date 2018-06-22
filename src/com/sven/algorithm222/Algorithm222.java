package com.sven.algorithm222;

public class Algorithm222 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int hLeft = 0, hRight = 0;
        TreeNode left = root, right = root;
        while (left != null) {
            hLeft++;
            left = left.left;
        }
        while (right != null) {
            hRight++;
            right = right.right;
        }
        if (hLeft == hRight) return Double.valueOf(Math.pow(2, hLeft)).intValue() - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}