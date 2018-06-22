package com.sven.algorithm234;

public class Algorithm234 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1), node2 = new ListNode(2), node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        System.out.println(new Solution().isPalindrome(node1));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

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

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode fast = head, slow = head;
        int n = 0;
        while (fast.next != null) {
            fast = fast.next;
            if (n++ % 2 == 1) slow = slow.next;
        }
        if (fast == slow) return true;
        ListNode node1 = head, node2 = slow.next;
        slow.next = null;
        node2 = reverseList(node2);

        while (node2 != null) {
            if (node1.val != node2.val) return false;
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }
}