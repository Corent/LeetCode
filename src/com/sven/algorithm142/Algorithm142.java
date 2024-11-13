package com.sven.algorithm142;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/5
 */
public class Algorithm142 {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(3), node1 = new ListNode(2), node2 = new ListNode(0), node3 = new ListNode(-4);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        new Solution().detectCycle(node0);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = null;
        while (fast != null && fast != slow) {
            fast = fast.next;
            if (fast != null) fast = fast.next;

            if (slow == null) slow = head;
            slow = slow.next;
        }

        if (fast == null) return null;
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            if (fast == slow) break;
            slow = slow.next;
        }
        return fast;
    }
}