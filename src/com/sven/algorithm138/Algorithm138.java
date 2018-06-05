package com.sven.algorithm138;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/5
 */
public class Algorithm138 {
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};

class Solution {

    private void cloneNodes(RandomListNode head) {
        RandomListNode ptr = head;
        while (ptr != null) {
            RandomListNode clone = new RandomListNode(ptr.label);
            clone.next = ptr.next;
            ptr.next = clone;
            ptr = clone.next;
        }
    }

    private void connectRandomNodes(RandomListNode head) {
        RandomListNode ptr = head;
        while (ptr != null) {
            RandomListNode clone = ptr.next;
            if (ptr.random != null) {
                clone.random = ptr.random.next;
            }
            ptr = clone.next;
        }
    }

    private RandomListNode reconnectNodes(RandomListNode head) {
        RandomListNode ptr = head, clonedHead = null, cloneNode = null;

        if (ptr != null) {
            clonedHead = cloneNode = ptr.next;
            ptr.next = cloneNode.next;
            ptr = ptr.next;
        }

        while (ptr != null) {
            cloneNode.next = ptr.next;
            cloneNode = cloneNode.next;
            ptr.next = cloneNode.next;
            ptr = ptr.next;
        }

        return clonedHead;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        cloneNodes(head);
        connectRandomNodes(head);
        return reconnectNodes(head);
    }
}