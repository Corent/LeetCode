package com.sven.algorithm142;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/5
 */
public class Algorithm142 {
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