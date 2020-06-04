package com.sven.algorithm110;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/24
 */
public class Algorithm110 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public boolean isBalanced(TreeNode root) {
        return isBalancedCore(root).isBalanced;
    }

    public Deepth isBalancedCore(TreeNode root) {
        if (root == null) return new Deepth(true, 0);
        Deepth deepthLeft = isBalancedCore(root.left);
        Deepth deepthRight = isBalancedCore(root.right);
        int deepth = Math.max(deepthLeft.deepth, deepthRight.deepth) + 1;
        if (!deepthLeft.isBalanced || !deepthRight.isBalanced) return new Deepth(false, deepth);
        return new Deepth(Math.abs(deepthLeft.deepth - deepthRight.deepth) <= 1, deepth);
    }

    class Deepth {
        public Boolean isBalanced;
        public Integer deepth;

        public Deepth(Boolean isBalanced, Integer deepth) {
            this.isBalanced = isBalanced;
            this.deepth = deepth;
        }
    }
}

class Solution2 {

    private boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (!balanced) return false;
        int deepLeft = deep(root.left);
        if (!balanced) return false;
        int deepRight = deep(root.right);
        if (!balanced) return false;
        return Math.abs(deepLeft - deepRight) < 2;
    }

    private int deep(TreeNode node) {
        if (node == null) return 0;
        int deepLeft = deep(node.left);
        int deepRight = deep(node.right);
        if (Math.abs(deepLeft - deepRight) > 1) balanced = false;
        return Math.max(deepLeft, deepRight) + 1;
    }
}