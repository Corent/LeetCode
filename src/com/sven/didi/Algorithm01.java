package com.sven.didi;

public class Algorithm01 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        Node node = new Solution().reverse(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    static class Node {
        int val;
        Node next;
        public Node(int val) { this.val = val; }
    }

    static class Solution {

        public Node reverse(Node node) {
            if (node == null || node.next == null) return node;
            Node pre = null, cur = node;
            while (cur != null) {
                Node tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            return pre;
        }
    }
}