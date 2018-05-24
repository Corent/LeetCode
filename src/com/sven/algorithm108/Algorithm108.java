package com.sven.algorithm108;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/24
 */
public class Algorithm108 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        this.nums = nums;
        return sortedArrayToBST(0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int from, int to) {
        if (!(from >= 0 && from <= to && to < nums.length)) return null;
        int mid = (from + to + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(from, mid - 1);
        root.right = sortedArrayToBST(mid + 1, to);
        return root;
    }
}