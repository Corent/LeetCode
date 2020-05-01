package com.sven.algorithm382;

import java.util.Random;

public class Algorithm382 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * https://blog.csdn.net/qq_33321609/article/details/103408173
 */
class Solution {

    private Random random = null;
    private ListNode head = null;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.random = new Random();
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode node = this.head;
        int point = 1, value = 0;
        Random random = new Random();
        while (node != null) {
            if (random.nextInt(point) == 0) {
                value = node.val;
            }
            node = node.next;
            point++;
        }
        return value;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */