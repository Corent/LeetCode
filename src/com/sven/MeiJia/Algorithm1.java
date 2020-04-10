package com.sven.MeiJia;

public class Algorithm1 {

    public static void main(String[] args) {
        // System.out.println(simpleSToI("123456"));
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        Node node5 = new Node(3);
        Node node6 = new Node(4);
        Node node7 = new Node(5);
        Node node8 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        Node ans = removeRepetitive(node1);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }

    private static int simpleSToI(String s) {

        if (s == null) throw new NullPointerException();

        s = s.trim();
        if (s.length() == 0) throw new RuntimeException();

        Long ans = 0L;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= '0' && c <= '9')) throw new RuntimeException();
            ans = ans * 10 + (c - '0');
        }
        return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : ans.intValue();
    }

    static class Node {
        int val;
        Node next;
        public Node(int val) { this.val = val; }
    }

    private static Node removeRepetitive(Node root) {
        if (root == null) return root;
        Node head = new Node(0);
        Node tmp = head, curr = root;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                int val = curr.val;
                while (curr != null && curr.val == val) {
                    curr = curr.next;
                }
                if (curr != null && curr.next != null && curr.val == curr.next.val) {
                    continue;
                }
            }
            if (curr != null) {
                tmp.next = curr;
                tmp = tmp.next;
                curr = curr.next;
            }
        }

        tmp.next = null;
        return head.next;
    }
}
