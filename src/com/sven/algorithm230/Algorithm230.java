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

class Solution {

    private List<Integer> list = new ArrayList<>();

    private void inOrder(TreeNode root) {
        if (root == null) return;
        if (root.left != null) inOrder(root.left);
        list.add(root.val);
        if (root.right != null) inOrder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return list.get(k - 1);
    }
}