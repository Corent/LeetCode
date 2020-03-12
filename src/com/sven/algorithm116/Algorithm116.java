package com.sven.algorithm116;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/28
 */
public class Algorithm116 {
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode>[] queues = new LinkedList[2];
        queues[0] = new LinkedList<>();
        queues[1] = new LinkedList<>();
        int idx = 0;
        queues[idx].add(root);
        TreeLinkNode preNode = null;
        while (!queues[idx].isEmpty()) {
            TreeLinkNode node = queues[idx].poll();
            if (preNode != null) preNode.next = node;
            preNode = node;
            if (node.left != null) queues[1 - idx].add(node.left);
            if (node.right != null) queues[1 - idx].add(node.right);
            if (queues[idx].isEmpty()) {
                idx = 1 - idx;
                preNode = null;
            }
        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution2 {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node>[] queues = new LinkedList[2];
        queues[0] = new LinkedList<>();
        queues[1] = new LinkedList<>();
        int idx = 0;
        queues[idx].add(root);
        Node preNode = null;
        while (!queues[idx].isEmpty()) {
            Node node = queues[idx].poll();
            if (preNode != null) preNode.next = node;
            preNode = node;
            if (node.left != null) queues[1 - idx].add(node.left);
            if (node.right != null) queues[1 - idx].add(node.right);
            if (queues[idx].isEmpty()) {
                idx = 1 - idx;
                preNode = null;
            }
        }
        return root;
    }
}