package com.sven.algorithm337;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/10
 */
public class Algorithm337 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 每个节点都有抢和不抢两种情况
 */

class Solution {

    //该节点可抢可不抢
    public int rob(TreeNode root) {
        if (root == null) return 0;

        int ifRob = root.val + robNot(root.left) + robNot(root.right);
        int ifNotRob = rob(root.left) + rob(root.right);
        return Math.max(ifRob, ifNotRob);
    }

    //该节点不抢
    private int robNot(TreeNode root) {
        if (root == null) return 0;
        return rob(root.left) + rob(root.right);
    }
}