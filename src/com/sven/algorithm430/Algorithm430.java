package com.sven.algorithm430;

public class Algorithm430 {
}


// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        Node ptr = head;
        while (ptr != null) {
            if (ptr.child == null) {
                ptr = ptr.next;
                continue;
            }

            Node next = ptr.next;
            ptr.next = flatten(ptr.child);
            ptr.next.prev = ptr;
            ptr.child = null;
            while (ptr.next != null) ptr = ptr.next;
            if (next != null) {
                ptr.next = next;
                next.prev = ptr;
            }
        }

        return head;
    }
}