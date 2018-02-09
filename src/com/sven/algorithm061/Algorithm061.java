package com.sven.algorithm061;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 09/02/2018
 */
public class Algorithm061 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode ans = new Solution().rotateRight(node1, 2);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
        System.out.println("null");
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) return head;
        int n = 0;
        ListNode ans = null, slow = null, fast = head;
        while (fast != null) {
            fast = fast.next;
            n++;
        }
        if (n < 2) return head;
        k %= n;
        if (k == 0) return head;
        fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ans = slow.next;
        slow.next = null;
        fast.next = head;
        return ans;
    }
}