package com.sven.algorithm025;

public class Algorithm025 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1), node2 = new ListNode(2), node3 = new ListNode(3), node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode ans = new Solution().reverseKGroup(node1, 2);
        while (ans != null) {
            System.out.println(ans.val + " ");
            ans = ans.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 分段，对每一段进行翻转操作
 */

class Solution {

    private void reverse(ListNode pre, ListNode node, int k) {
        if (pre == null || node == null) return;
        ListNode tmp1 = node, tmp2 = node.next;
        ListNode tmp = tmp2.next;
        for (int i = 1; i < k; i++) {
            tmp2.next = tmp1;
            tmp1 = tmp2;
            tmp2 = tmp;
            tmp = tmp2 == null? null: tmp2.next;
        }
        node.next = tmp2;
        pre.next = tmp1;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode newHead = new ListNode(0) {{ next = head; }};
        ListNode pre = newHead, node1 = head, node2 = head;
        while (node1 != null && node2 != null) {
            for (int i = 1; i < k; i++) {
                if (node2 == null) return newHead.next;
                node2 = node2.next;
            }
            if (node2 == null) return newHead.next;
            reverse(pre, node1, k);
            pre = node1;
            node2 = node1.next;
            node1 = node1.next;
        }
        return newHead.next;
    }
}