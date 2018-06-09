package com.sven.algorithm203;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/9
 */
public class Algorithm203 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head, root = new ListNode(0);
        root.next = head;
        ListNode prev = root;
        while (node != null) {
            if (node.val == val) {
                node = node.next;
                prev.next = node;
                continue;
            }

            prev = node;
            node = node.next;
        }
        return root.next;
    }
}