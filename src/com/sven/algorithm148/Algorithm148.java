package com.sven.algorithm148;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/6
 */
public class Algorithm148 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 归并排序
 */

class Solution {

    private ListNode merge(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head, tmp;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        tmp = head;

        while (list1 != null && list2!= null) {
            if (list1.val < list2.val) {
                tmp.next = list1;
                tmp = list1;
                list1 = list1.next;
            } else {
                tmp.next = list2;
                tmp = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) tmp.next = list1;
        if (list2 != null) tmp.next = list2;

        return head;
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode list1 = sortList(head), list2 = sortList(mid);
        return merge(list1, list2);
    }
}