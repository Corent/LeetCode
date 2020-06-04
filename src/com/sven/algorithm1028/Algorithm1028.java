package com.sven.algorithm1028;

public class Algorithm1028 {

    public static void main(String[] args) {
        TreeNode node = new Solution().recoverFromPreorder("1-2--3--4-5--6--7");
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    private int[][] nodes;

    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0) return null;
        String[] s1 = S.split("-+");
        String[] s2 = S.split("\\d+");
        if (s2.length == 0) return new TreeNode(Integer.valueOf(s1[0]));
        nodes = new int[s1.length][2];    //  nodes[i][0]表示第i个数，nodes[i][1]表示第i个数的深度
        for (int i = 0; i < s1.length; i++) {
            nodes[i][0] = Integer.valueOf(s1[i]);
            nodes[i][1] = s2[i].length();
        }

        return recoverFromPreorder(0, nodes.length - 1);
    }

    private TreeNode recoverFromPreorder(int from, int to) {
        if (from > to) return null;
        TreeNode node = new TreeNode(nodes[from][0]);
        if (from == to) return node;
        int idx1 = from + 1;
        while (idx1 <= to && nodes[idx1][1] != nodes[from][1] + 1) idx1++;
        if (idx1 > to) return node; //  No left child
        int idx2 = idx1 + 1;
        while (idx2 <= to && nodes[idx2][1] != nodes[from][1] + 1) idx2++;
        if (idx2 > to) {    //  No right child
            node.left = recoverFromPreorder(idx1, to);
        } else {
            node.left = recoverFromPreorder(idx1, idx2 - 1);
            node.right = recoverFromPreorder(idx2, to);
        }
        return node;
    }
}