package com.sven.algorithm538;

public class Algorithm538 {
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

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        convertBSTCore(root);
        return root;
    }

    public void convertBSTCore(TreeNode node) {
        if (node == null) return;
        convertBSTCore(node.right);
        int val = node.val;
        node.val += sum;
        sum += val;
        convertBSTCore(node.left);
    }
}