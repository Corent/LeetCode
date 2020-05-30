package com.sven.tencent;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {
}

/**
 * M个升序单链表，每个节点存储的都是整型值，实现算法返回前N个最小数
 */
class Solution {

    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public List<Integer> findMins(Node[] nodes, int n) {
        List<Integer> ans = new ArrayList<>();
        if (nodes == null || nodes.length == 0) return ans;
        while (ans.size() < n) {
            Integer idx = null;
            Node node = null;
            for (int i = 0; i < nodes.length; i++) {
                if (node == null) {
                    node = nodes[i];
                    idx = i;
                } else if (nodes[i] != null && node.val > nodes[i].val) {
                    node = nodes[i];
                    idx = i;
                }
            }
            if (node == null) break;
            ans.add(node.val);
            nodes[idx] = nodes[idx].next;
        }
        return ans;
    }
}