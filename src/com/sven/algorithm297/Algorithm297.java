package com.sven.algorithm297;

import java.util.LinkedList;

public class Algorithm297 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);

        treeNode1.left = treeNode2;

        Codec codec = new Codec();
        String s = codec.serialize(treeNode1);
        System.out.println(s);
        TreeNode treeNode = codec.deserialize(s);
        System.out.println();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node != null) {
                builder.append(node.val).append(",");
                queue.addLast(node.left);
                queue.addLast(node.right);
            } else {
                builder.append("null,");
            }
        }
        return '[' + builder.substring(0, builder.length() - 1) + ']';
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 2) return null;
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        TreeNode root = nodes[0].equals("null")? null: new TreeNode(Integer.valueOf(nodes[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.addLast(root);
        int idx = 1;
        while (!queue.isEmpty()) {
            String sLeft = nodes[idx++], sRight = nodes[idx++];
            TreeNode left = sLeft.equals("null")? null: new TreeNode(Integer.valueOf(sLeft));
            TreeNode right = sRight.equals("null")? null: new TreeNode(Integer.valueOf(sRight));
            TreeNode node = queue.pollFirst();
            node.left = left;
            node.right = right;
            if (left != null) queue.addLast(left);
            if (right != null) queue.addLast(right);
        }
        return root;
    }
}