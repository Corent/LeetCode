package com.sven.algorithm114;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/28
 */
public class Algorithm114 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left, right = root.right, tmp = null;
        flatten(left);
        flatten(right);
        root.left = null;
        if (left != null) {
            root.right = left;
            tmp = root.right;
            while (tmp.right != null) tmp = tmp.right;
            tmp.right = right;
        }
    }
}