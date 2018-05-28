package com.sven.algorithm113;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/25
 */
public class Algorithm113 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSumCore(root, sum);
        return ans;
    }

    private void pathSumCore(TreeNode root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                path.add(root.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        if (root.left != null) pathSumCore(root.left, sum - root.val);
        if (root.right != null) pathSumCore(root.right, sum - root.val);
        path.remove(path.size() - 1);
    }
}