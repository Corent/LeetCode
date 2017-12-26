package com.sven.algorithm002;

import java.util.List;
import java.util.Stack;

public class Algorithm002 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l3 = new Solution().addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.print(l3.val + "->");
            l3 = l3.next;
        }
        System.out.print("null");
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 从低位起依次加和，注意进位和链表边界
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null? 0: l1.val, n2 = l2 == null? 0: l2.val;
            int n3 = n1 + n2 + carry;
            carry = n3 / 10;
            tmp.next = new ListNode(n3 % 10);
            tmp = tmp.next;
            l1 = l1 == null? null: l1.next;
            l2 = l2 == null? null: l2.next;
        }
        if (carry > 0) {
            tmp.next = new ListNode(carry);
        }
        return head.next;
    }
}