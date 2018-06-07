package com.sven.algorithm145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/5
 */
public class Algorithm145 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left == null && node.right == null) {
                stack.pop();
                ans.add(node.val);
                continue;
            }

            if (node.right != null) {
                stack.push(node.right);
                node.right = null;
            }

            if (node.left != null) {
                stack.push(node.left);
                node.left = null;
            }
        }
        return ans;
    }
}