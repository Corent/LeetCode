package com.sven.algorithm021;

public class Algorithm021 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 当两者都不为空时循环判断
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tmp.next = l2;
                break;
            } else if (l2 == null) {
                tmp.next = l1;
                break;
            } else {
                if (l1.val < l2.val) {
                    tmp.next = l1;
                    l1 = l1.next;
                    tmp = tmp.next;
                } else {
                    tmp.next = l2;
                    l2 = l2.next;
                    tmp = tmp.next;
                }
            }
        }
        return head.next;
    }
}