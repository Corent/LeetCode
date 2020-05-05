package com.sven.algorithm450;

public class algorithm450 {
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (!containNode(root, key)) return root;
        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode successor = findMin(root.right);
            successor.right = delMin(root.right);
            successor.left = root.left;
            return successor;
        } else {
            if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else {
                root.left = deleteNode(root.left, key);
            }
            return root;
        }
    }

    private boolean containNode(TreeNode treeNode, int key) {
        if (treeNode == null) return false;
        if (treeNode.val == key) return true;
        if (treeNode.val > key) return containNode(treeNode.left, key);
        return containNode(treeNode.right, key);
    }

    /*
     * return a treeNode whose key is the minimum in the tree
     */
    private TreeNode findMin(TreeNode treeNode) {
        TreeNode cur = treeNode;
        while (cur != null) {
            if (cur.left == null) return cur;
            cur = cur.left;
        }
        return cur;
    }

    /*
     * return a treeNode after deleting its treeNode whose key is the minimum
     */
    private TreeNode delMin(TreeNode treeNode) {
        if (treeNode.left == null) return treeNode.right;
        treeNode.left = delMin(treeNode.left);
        return treeNode;
    }
}