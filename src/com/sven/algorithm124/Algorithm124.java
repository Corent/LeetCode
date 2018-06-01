package com.sven.algorithm124;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/1
 */
public class Algorithm124 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumCore(root);
        return ans;
    }

    private int maxPathSumCore(TreeNode root) { //返回从root到叶节点的最大长度
        if (root == null) return 0 ;

        Integer maxLeft = root.left != null? maxPathSumCore(root.left): 0;
        Integer maxRight = root.right != null? maxPathSumCore(root.right): 0;

        if (maxLeft > 0 && maxRight > 0) {
            ans = Math.max(ans, maxLeft + root.val + maxRight);
            return root.val + Math.max(maxLeft, maxRight);
        }

        if (maxLeft > 0) {
            ans = Math.max(ans, maxLeft + root.val);
            return root.val + maxLeft;
        }

        if (maxRight > 0) {
            ans = Math.max(ans, maxRight + root.val);
            return root.val + maxRight;
        }

        ans = Math.max(ans, root.val);
        return root.val;
    }
}