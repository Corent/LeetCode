package com.sven.algorithm206;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/9
 */
public class Algorithm206 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 迭代
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = prev;
            prev = tmp;
        }
        return prev;
    }
}

/**
 * 递归
 */
class Solution2 {

    private ListNode root = new ListNode(0);

    public ListNode reverseList(ListNode head) {
        reverseListCore(head);
        return root.next;
    }

    public ListNode reverseListCore(ListNode head) {
        if (head == null) return root;
        ListNode prev = reverseListCore(head.next);
        prev.next = head;
        head.next = null;
        return head;
    }
}