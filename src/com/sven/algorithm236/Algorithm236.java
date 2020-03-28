package com.sven.algorithm236;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/1
 */
public class Algorithm236 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private TreeNode LCA;

    private int find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || LCA != null) return 0;
        int found = 0;
        if (root.left != null && LCA == null) found += find(root.left, p, q);
        if (root.right != null && LCA == null) found += find(root.right, p, q);
        if (root == p) found++;
        if (root == q) found++;
        if (found == 2 && LCA == null) LCA = root;
        return found;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return LCA;
    }
}

/**
 * https://blog.csdn.net/u013554860/article/details/99702471
 */
class Solution2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left == null) return right;
        return left;
    }
}