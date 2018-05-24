package com.sven.algorithm105;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/23
 */
public class Algorithm105 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        int len1 = preorder.length, len2 = inorder.length;
        if (len1 != len2 || len1 == 0) return null;
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTree(0, len1 - 1, 0, len2 - 1);
    }

    private TreeNode buildTree(int from1, int to1, int from2, int to2) {
        if (from1 > to1 || from2 > to2 || to1 - from1 != to2 - from2) return null;
        TreeNode root = new TreeNode(preorder[from1]);
        int idx = -1;
        for (int i = from2; i <= to2; i++) {
            if (inorder[i] == root.val) {
                idx = i;
                break;
            }
        }
        if (idx == -1) return null;
        root.left = buildTree(from1 + 1, from1 + idx - from2, from2, idx - 1);
        root.right = buildTree(from1 + idx - from2 + 1, to1, idx + 1, to2);
        return root;
    }
}