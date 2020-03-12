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

/**
 * https://www.cnblogs.com/ariel-dreamland/p/9159367.html
 */
class Solution2 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode root = new ListNode(-1), newRoot = new ListNode(-1);
        root.next = head;
        ListNode cur = root, cur1 = newRoot;
        while (cur.next != null) {
            if (cur.next.val < x) {
                cur1.next = cur.next;
                cur1 = cur1.next;
                cur.next = cur.next.next;
                cur1.next = null;
            } else {
                cur = cur.next;
            }
        }
        cur1.next = root.next;
        return newRoot.next;
    }
}