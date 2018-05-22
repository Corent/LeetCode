package com.sven.algorithm092;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/19
 */
public class Algorithm092 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == n) return head;

        int idx = 1;
        ListNode pre = null, cur = head, p = null;

        while (cur != null) {
            if (idx == m) {
                p = pre;
                pre = cur;
                cur = cur.next;
                idx++;
                continue;
            }

            if (idx == n) {
                if (p != null) {
                    p.next.next = cur.next;
                    cur.next = pre;
                    p.next = cur;
                } else {
                    head.next = cur.next;
                    head = cur;
                    cur.next = pre;
                }
                break;
            }

            if (idx <= m) {
                pre = cur;
                cur = cur.next;
            } else {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            idx++;
        }

        return head;
    }
}