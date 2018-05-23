package com.sven.algorithm094;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/22
 */
public class Algorithm094 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private List<Integer> ans;

    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        inorderTraversalCore(root);
        return ans;
    }

    private void inorderTraversalCore(TreeNode node) {
        if (node == null) return;
        inorderTraversalCore(node.left);
        ans.add(node.val);
        inorderTraversalCore(node.right);
    }
}