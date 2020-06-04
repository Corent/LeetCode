package com.sven.algorithm023;

import java.util.*;

public class Algorithm023 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 分治，转换为Algorithm021 mergeTwoSortedList问题
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int l, int r) {
        if (l < r) {
            int m = (l + r)/2;
            return mergeTwoLists(helper(lists, l, m), helper(lists,m+1, r));
        }
        return lists[l];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

/**
 * 笨办法，能过但不推荐
 */
class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        List<Integer> list = new ArrayList<>();
        for (ListNode node: lists) {
            ListNode tmp = node;
            while (tmp != null) {
                list.add(tmp.val);
                tmp = tmp.next;
            }
        }
        Collections.sort(list);
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        for (Integer i: list) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        return head.next;
    }
}

class Solution3 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode root = new ListNode(0);
        PriorityQueue<ListNode> nodes = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node: lists) {
            if (node != null) {
                nodes.add(node);
            }
        }
        ListNode node = root;
        while (!nodes.isEmpty()) {
            ListNode nextNode = nodes.poll();
            node.next = nextNode;
            nextNode = nextNode.next;
            node = node.next;
            if (nextNode != null) {
                nodes.add(nextNode);
            }
        }
        return root.next;
    }
}

/**
 * 超时
 */
/*class Solution3 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (tmp != null) {
            Integer idx = null;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && (idx == null || lists[idx].val > lists[i].val))
                    idx = i;
            }
            if (idx != null) {
                tmp.next = lists[idx];
                lists[idx] = lists[idx].next;
            } else tmp.next = null;
            tmp = tmp.next;
        }
        return head.next;
    }
}*/
