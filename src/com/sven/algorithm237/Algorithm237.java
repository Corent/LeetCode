package com.sven.algorithm237;

public class Algorithm237 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public void deleteNode(ListNode node) {
        int tmp = node.next.val;
        node.next = node.next.next;
        node.val = tmp;
    }
}