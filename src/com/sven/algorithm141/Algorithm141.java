package com.sven.algorithm141;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/5
 */
public class Algorithm141 {
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
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = null;
        while (fast != null && fast != slow) {
            fast = fast.next;
            if (fast == null || fast == slow) break;
            fast = fast.next;
            if (fast == null || fast == slow) break;
            if (slow == null) slow = head;
            slow = slow.next;
        }
        return fast != null;
    }
}