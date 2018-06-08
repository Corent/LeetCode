package com.sven.algorithm173;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/8
 */
public class Algorithm173 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class BSTIterator {

    private int idx = -1;
    private List<Integer> nums = new ArrayList<>();

    private void init(TreeNode root) {
        if (root == null) return;
        init(root.left);
        nums.add(root.val);
        init(root.right);
    }

    public BSTIterator(TreeNode root) {
        init(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (idx + 1) < nums.size();
    }

    /** @return the next smallest number */
    public int next() {
        return nums.get(++idx);
    }
}