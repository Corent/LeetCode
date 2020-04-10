package com.sven.Xiaomi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Xiaomi {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> level = new ArrayList<>();
        Stack<TreeNode>[] stacks = new Stack[] { new Stack<>(), new Stack<>() };
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();
        int idx = 0, levelIdx = 0;
        stacks[idx].add(root);
        while (!stacks[idx].isEmpty()) {
            TreeNode node = stacks[idx].pop();
            level.add(node.val);
            if ((levelIdx & 1) == 0) {
                if (node.left != null) stacks[1 - idx].push(node.left);
                if (node.right != null) stacks[1 - idx].push(node.right);
            } else {
                if (node.right != null) stacks[1 - idx].push(node.right);
                if (node.left != null) stacks[1 - idx].push(node.left);
            }
            if (stacks[idx].isEmpty()) {
                ans.add(new ArrayList<>(level));
                level.clear();
                idx = 1 - idx;
                levelIdx++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;

        Xiaomi codec = new Xiaomi();
        String s = codec.serialize(node1);
        System.out.println(s);

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(codec.deserialize(s));
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            System.out.print(node.val + " ");
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
        }
        System.out.println();
    }

    public String serialize(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node != null) {
                builder.append(node.val).append(" ");
                queue.addLast(node.left);
                queue.addLast(node.right);
            } else {
                builder.append("null ");
            }
        }
        return builder.substring(0, builder.length() - 1);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] nodes = data.split(" ");
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
