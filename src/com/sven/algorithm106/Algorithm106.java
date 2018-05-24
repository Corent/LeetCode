package com.sven.algorithm106;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/23
 */
public class Algorithm106 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private int[] inorder;
    private int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null) return null;
        int len1 = postorder.length, len2 = inorder.length;
        if (len1 != len2 || len1 == 0) return null;
        this.inorder = inorder;
        this.postorder = postorder;
        return buildTree(0, len2 - 1, 0, len1 - 1);
    }

    private TreeNode buildTree(int from1, int to1, int from2, int to2) {
        if (from1 > to1 || from2 > to2 || to1 - from1 != to2 - from2) return null;
        TreeNode root = new TreeNode(postorder[to2]);
        int idx = -1;
        for (int i = from1; i <= to1; i++) {
            if (inorder[i] == root.val) {
                idx = i;
                break;
            }
        }
        if (idx == -1) return null;
        root.left = buildTree(from1, idx - 1, from2, from2 + idx - from1 - 1);
        root.right = buildTree(idx + 1, to1, from2 + idx - from1, to2 - 1);
        return root;
    }
}