package com.sven.algorithm328;

public class Algorithm328 {

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddNode = head, evenNode = head.next, firstEvenNode = head.next;
        ListNode[] nodes = new ListNode[] { oddNode, evenNode };
        int idx = 1;
        while (nodes[idx].next != null) {
            nodes[1 - idx].next = nodes[idx].next;
            nodes[1 - idx] = nodes[1 - idx].next;
            idx = 1 - idx;
        }
        nodes[1].next = null;
        nodes[0].next = firstEvenNode;
        return head;
    }
}