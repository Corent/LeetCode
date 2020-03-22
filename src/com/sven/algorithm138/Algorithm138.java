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

class Node {
    int val;
    Node next, random;
    Node(int x) { this.val = x; }
};

class Solution {

    private void cloneNodes(Node head) {
        Node ptr = head;
        while (ptr != null) {
            Node clone = new Node(ptr.val);
            clone.next = ptr.next;
            ptr.next = clone;
            ptr = clone.next;
        }
    }

    private void connectRandomNodes(Node head) {
        Node ptr = head;
        while (ptr != null) {
            Node clone = ptr.next;
            if (ptr.random != null) {
                clone.random = ptr.random.next;
            }
            ptr = clone.next;
        }
    }

    private Node reconnectNodes(Node head) {
        Node ptr = head, clonedHead = null, cloneNode = null;

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

    public Node copyRandomList(Node head) {
        cloneNodes(head);
        connectRandomNodes(head);
        return reconnectNodes(head);
    }
}