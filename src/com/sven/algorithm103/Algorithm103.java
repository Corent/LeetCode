package com.sven.algorithm103;

import java.util.*;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/23
 */
public class Algorithm103 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> level = new ArrayList<>();
        Stack<TreeNode>[] stacks = new Stack[2];
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();
        int idx = 0, levelIdx = 0;
        stacks[idx].add(root);
        while (!stacks[idx].isEmpty()) {
            TreeNode node = stacks[idx].pop();
            level.add(node.val);
            if ((levelIdx & 1) == 0) {
                if (node.left != null) stacks[1 - idx].push(node.left);
                if (node.right != null) stacks[1 - idx].push(node.right);
            } else {
                if (node.right != null) stacks[1 - idx].push(node.right);
                if (node.left != null) stacks[1 - idx].push(node.left);
            }
            if (stacks[idx].isEmpty()) {
                ans.add(new ArrayList<>(level));
                level.clear();
                idx = 1 - idx;
                levelIdx++;
            }
        }
        return ans;
    }
}