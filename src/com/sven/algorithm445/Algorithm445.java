package com.sven.algorithm445;

import java.util.Stack;

public class Algorithm445 {
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * Algorithm 002 & Algorithm 206
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        l1 = reverseList(l1);
        l2 = reverseList(l2);
        return reverseList(addTwoNumbersCore(l1, l2));
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = prev;
            prev = tmp;
        }
        return prev;
    }

    private ListNode addTwoNumbersCore(ListNode l1, ListNode l2) {
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

/**
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 */
class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode node = l1;
        while (node != null) {
            stack1.push(node.val);
            node = node.next;
        }
        node = l2;
        while (node != null) {
            stack2.push(node.val);
            node = node.next;
        }

        int carrier = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int n1 = stack1.isEmpty() ? 0 : stack1.pop();
            int n2 = stack2.isEmpty() ? 0 : stack2.pop();
            int n = n1 + n2 + carrier;
            carrier = n / 10;
            if (node == null) node = new ListNode(n % 10);
            else {
                ListNode prev = new ListNode(n % 10);
                prev.next = node;
                node = prev;
            }
        }
        if (carrier != 0) {
            ListNode prev = new ListNode(carrier % 10);
            prev.next = node;
            node = prev;
        }

        return node;
    }
}