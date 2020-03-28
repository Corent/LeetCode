package com.sven.algorithm095;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/22
 */
public class Algorithm095 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * Similar problem: Algorithm 241 https://leetcode.com/problems/different-ways-to-add-parentheses
 */
class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<>();
        return generateTreesCore(1, n);
    }

    private List<TreeNode> generateTreesCore(int from, int to) {
        List<TreeNode> ans = new ArrayList<>();
        if (from > to) {
            ans.add(null);
            return ans;
        }

        for (int i = from; i <= to; i++) {
            List<TreeNode> lefts = generateTreesCore(from, i - 1);
            List<TreeNode> rights = generateTreesCore(i + 1, to);
            for (TreeNode l: lefts) {
                for (TreeNode r: rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }

        return ans;
    }
}