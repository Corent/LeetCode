package com.sven.algorithm337;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/10
 */
public class Algorithm337 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 每个节点都有抢和不抢两种情况
 */

class Solution {

    private Map<TreeNode, Integer> ifRobMap = new HashMap<>();
    private Map<TreeNode, Integer> ifRobNotMap = new HashMap<>();

    //该节点可抢可不抢
    public int rob(TreeNode root) {
        if (root == null) return 0;

        Integer ifRobInMap = ifRobMap.get(root);
        int ifRob = ifRobInMap != null ? ifRobInMap : root.val + robNot(root.left) + robNot(root.right);
        if (ifRobInMap == null) ifRobMap.put(root, ifRob);

        Integer ifRobNotInMap = ifRobNotMap.get(root);
        int ifNotRob = ifRobNotInMap != null ? ifRobNotInMap : rob(root.left) + rob(root.right);
        if (ifRobNotInMap == null) ifRobNotMap.put(root, ifNotRob);

        return Math.max(ifRob, ifNotRob);
    }

    //该节点不抢
    private int robNot(TreeNode root) {
        if (root == null) return 0;
        if (ifRobNotMap.containsKey(root)) return ifRobNotMap.get(root);
        int max = rob(root.left) + rob(root.right);
        ifRobNotMap.put(root, max);
        return max;
    }
}