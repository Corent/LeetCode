package com.sven.Samsung.Algorithm001;

public class Main {

    public static void main(String[] srgs) {
        int[] line1 = new int[] { 13, 12, 8, 13 };
        int[] line2 = new int[] { 1, 2, 1, 3, 2, 4, 3, 5, 3, 6, 4, 7, 7, 12, 5, 9, 5, 8, 6, 10, 6, 11, 11, 13 };

        Node[] nodes = new Node[line1[0]];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }

        for (int i = 0; i < line1[1]; i++) {
            int idxFrom = line2[2 * i] - 1;
            int idxTo = line2[2 * i + 1] - 1;
            if (nodes[idxFrom].left == null) {
                nodes[idxFrom].left = nodes[idxTo];
            } else {
                nodes[idxFrom].right = nodes[idxTo];
            }
        }

        Node node = findLCA(nodes[0], nodes[line1[2] - 1], nodes[line1[3] - 1]);

        System.out.println(node.val + " " + countNodes(node));
    }

    public static Node findLCA(Node root, Node p, Node q) {
        if (root == null) return null;
        if (root == p) return root;
        if (root == q) return root;
        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    public static int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

