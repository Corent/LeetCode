package com.sven.algorithm143;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/5
 */
public class Algorithm143 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        List<ListNode> nodes = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }

        int i = 0, n = nodes.size() - 1;
        while (i < n - i) {
            ListNode node1 = nodes.get(i), node2 = nodes.get(n - i);
            node2.next = node1.next;
            node1.next = node2;
            i++;
        }
        nodes.get((n + 1) / 2).next = null;
    }
}