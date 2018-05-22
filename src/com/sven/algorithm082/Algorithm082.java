package com.sven.algorithm082;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/17
 */
public class Algorithm082 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode node = head, root = new ListNode(0);
        while (node != null) {
            Integer cnt = map.get(node.val);
            if (cnt == null) cnt = 0;
            map.put(node.val, cnt + 1);
            node = node.next;
        }
        node = root;
        while (head != null) {
            if (map.get(head.val) < 2) {
                node.next = head;
                node = node.next;
            }
            head = head.next;
        }
        node.next = null;
        return root.next;
    }
}