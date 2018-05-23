package com.sven.algorithm099;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/23
 */
public class Algorithm099 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private TreeNode previous;
    private TreeNode mistake1;
    private TreeNode mistake2;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        recoverTreeCore(root);
        if (mistake1 != null && mistake2 != null) {
            int tmp = mistake1.val;
            mistake1.val = mistake2.val;
            mistake2.val = tmp;
        }
    }

    private void recoverTreeCore(TreeNode root) {

        if (root == null) return;
        recoverTreeCore(root.left);
        if (previous != null && previous.val >= root.val) {
            if (mistake1 == null) {
                mistake1 = previous;
                mistake2 = root;
            } else mistake2 = root;
        }
        previous = root;
        recoverTreeCore(root.right);
    }
}