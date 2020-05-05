package com.sven.algorithm437;

public class Algorithm437 {

    public static void main(String[] args) {
        /*TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node5.right = node9;

        System.out.println(new Solution().pathSum(node1, 8));*/

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;

        System.out.println(new Solution().pathSum(node1, 3));
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

    private int ans = 0;
    private int target;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        target = sum;
        pathSumCore(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return ans;
    }

    private void pathSumCore(TreeNode root, int sum) {
        if (root == null) return;
        if (root.val == sum) ans++;

        if (root.left != null) {
            pathSumCore(root.left, sum - root.val);
        }
        if (root.right != null) {
            pathSumCore(root.right, sum - root.val);
        }
    }
}