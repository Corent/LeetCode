package com.sven.algorithm086;

import java.util.LinkedList;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/19
 */
public class Algorithm086 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode root = new ListNode(0), node = head;
        if (head == null) return null;
        LinkedList<ListNode> less = new LinkedList<>(), more = new LinkedList<>();
        while (node != null) {
            if (node.val < x) less.add(node);
            else more.add(node);
            node = node.next;
        }
        node = root;
        while (!less.isEmpty()) {
            node.next = less.pollFirst();
            node = node.next;
        }
        while (!more.isEmpty()) {
            node.next = more.pollFirst();
            node = node.next;
        }
        node.next = null;
        return root.next;
    }
}