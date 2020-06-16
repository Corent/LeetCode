package com.sven.algorithm637;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Algorithm637 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode>[] queues = new LinkedList[] { new LinkedList<>(), new LinkedList<>() };
        double sum = 0;
        int idx = 0, cnt = 0;
        queues[idx].add(root);
        while (!queues[idx].isEmpty()) {
            TreeNode node = queues[idx].poll();
            sum += node.val;
            cnt++;
            if (node.left != null) queues[1 - idx].add(node.left);
            if (node.right != null) queues[1 - idx].add(node.right);
            if (queues[idx].isEmpty()) {
                ans.add(sum / cnt);
                sum = 0;
                cnt = 0;
                idx = 1 - idx;
            }
        }
        return ans;
    }
}