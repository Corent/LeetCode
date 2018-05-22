package com.sven.algorithm083;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/17
 */
public class Algorithm083 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode node = head, ans = null, ptr = null;
        while (node != null) {
            if (ans == null) {
                ans = node;
                ptr = ans;
            } else if (node.val != ptr.val) {
                ptr.next = node;
                ptr = ptr.next;
            }
            node = node.next;
        }
        ptr.next = null;
        return ans;
    }
}