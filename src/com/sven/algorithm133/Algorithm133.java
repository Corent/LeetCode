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
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
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