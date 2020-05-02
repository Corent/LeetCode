package com.sven.algorithm429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Algorithm429 {
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> level = new ArrayList<>();
        Queue<Node>[] queues = new LinkedList[] { new LinkedList<>(), new LinkedList<>() };
        int idx = 0;
        queues[idx].add(root);
        while (!queues[idx].isEmpty()) {
            Node node = queues[idx].poll();
            level.add(node.val);
            for (Node n: node.children) queues[1 - idx].add(n);
            if (queues[idx].isEmpty()) {
                ans.add(new ArrayList<>(level));
                level.clear();
                idx = 1 - idx;
            }
        }
        return ans;
    }
}