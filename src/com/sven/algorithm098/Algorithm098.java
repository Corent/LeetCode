package com.sven.algorithm098;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/23
 */
public class Algorithm098 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 中序遍历结果是有序数列
 */
class Solution {

    private List<Integer> vals = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (isValidBST(root.left)) {
            int cnt = vals.size();
            if (cnt == 0 || root.val > vals.get(cnt - 1)) {
                vals.add(root.val);
                return isValidBST(root.right);
            } else return false;
        } else return false;
    }
}