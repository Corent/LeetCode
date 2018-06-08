package com.sven.algorithm199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/8
 */
public class Algorithm199 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode>[] ques = new LinkedList[2];
        ques[0] = new LinkedList<>();
        ques[1] = new LinkedList<>();
        int idx = 0;
        ques[idx].add(root);
        while (!ques[idx].isEmpty()) {
            TreeNode node = null;
            while (!ques[idx].isEmpty()) {
                node = ques[idx].poll();
                if (node.left != null) ques[1 - idx].add(node.left);
                if (node.right != null) ques[1 - idx].add(node.right);
            }
            if (node != null) ans.add(node.val);
            idx = 1 - idx;
        }
        return ans;
    }
}