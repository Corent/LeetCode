package com.sven.algorithm147;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/6
 */
public class Algorithm147 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode tmp = dummy, next = head.next;
            while (tmp.next != null && tmp.next.val < head.val) {
                tmp = tmp.next;
            }
            head.next = tmp.next;
            tmp.next = head;
            head = next;
        }

        return dummy.next;
    }
}