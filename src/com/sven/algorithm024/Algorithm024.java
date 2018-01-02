package com.sven.algorithm024;

public class Algorithm024 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * pre node1 node2 三个指针，交换node1 node2往后移动，node1或node2为空时跳出循环
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode newHead = new ListNode(0) {{ next = head; }};
        ListNode pre = newHead, node1 = head, node2 = head.next;
        while (node1 != null && node2 != null) {
            ListNode tmp = node2.next;
            node2.next = node1;
            node1.next = tmp;
            pre.next = node2;
            pre = node1;
            if (node1 == null || node1.next == null) break;
            node1 = node1.next;
            node2 = node1.next;
        }
        return newHead.next;
    }
}