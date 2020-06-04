package com.sven.algorithm230;

import java.util.ArrayList;
import java.util.List;

public class Algorithm230 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 剑指Offer 面试题63
 */
class Solution {

    private int k;
    private int ans = 0;
    private int idx = 0;

    private void inOrder(TreeNode root) {
        if (root == null) return;
        if (root.left != null) inOrder(root.left);
        if (++idx == k) {
            ans = root.val;
            return;
        }
        if (root.right != null) inOrder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return ans;
    }
}