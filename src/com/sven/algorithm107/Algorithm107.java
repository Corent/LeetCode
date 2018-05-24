package com.sven.algorithm107;

import java.util.*;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/23
 */
public class Algorithm107 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> stack = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode>[] queues = new LinkedList[2];
        queues[0] = new LinkedList<>();
        queues[1] = new LinkedList<>();
        int idx = 0;
        queues[idx].add(root);
        while (!queues[idx].isEmpty()) {
            TreeNode node = queues[idx].poll();
            level.add(node.val);
            if (node.left != null) queues[1 - idx].add(node.left);
            if (node.right != null) queues[1 - idx].add(node.right);
            if (queues[idx].isEmpty()) {
                stack.push(new ArrayList<>(level));
                level.clear();
                idx = 1 - idx;
            }
        }
        while (!stack.isEmpty()) ans.add(stack.pop());
        return ans;
    }
}