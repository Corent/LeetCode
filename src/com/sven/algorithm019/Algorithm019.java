package com.sven.algorithm019;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithm019 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 用一个map存储第i个位置上的节点
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) return null;
        int index = 1;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode tmp = head;
        while (tmp != null) {
            map.put(index, tmp);
            index++;
            tmp = tmp.next;
        }

        if (n == 1 && index > 2) map.get(index - 2).next = null;
        else if (n == index - 1) return head.next;
        else map.get(index - n - 1).next = map.get(index - n + 1);

        return head;
    }
}

class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) return null;
        ListNode root = new ListNode(0), node = head;
        root.next = head;
        while (n > 0) {
            if (node == null) return root.next;
            node = node.next;
            n--;
        }
        ListNode pre = root, tmp = head;
        while (node != null) {
            node = node.next;
            pre = tmp;
            tmp = tmp.next;
        }
        pre.next = tmp.next;
        return root.next;
    }
}