package com.sven.algorithm133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/4
 */
public class Algorithm133 {
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
};

class Solution {

    private Map<Integer, UndirectedGraphNode> visited = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (visited.containsKey(node.label)) return visited.get(node.label);

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        List<UndirectedGraphNode> neighbors = node.neighbors;
        newNode.neighbors = new ArrayList<>(node.neighbors.size());
        visited.put(node.label, newNode);
        for (UndirectedGraphNode n: neighbors) newNode.neighbors.add(cloneGraph(n));

        return newNode;
    }
}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution2 {

    private Map<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (visited.containsKey(node.val)) return visited.get(node.val);

        Node newNode = new Node(node.val);
        visited.put(newNode.val, newNode);
        for (Node n: node.neighbors) newNode.neighbors.add(cloneGraph(cloneGraph(n)));
        return newNode;
    }
}