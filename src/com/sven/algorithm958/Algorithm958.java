package com.sven.algorithm958;

import java.util.LinkedList;

public class Algorithm958 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode preNode = root;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (preNode == null && node != null) {
                return false;
            }
            preNode = node;
            if (node != null) {
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
        }
        return true;
    }
}