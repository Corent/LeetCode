package com.sven.algorithm099;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/23
 */
public class Algorithm099 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private TreeNode previous;
    private TreeNode mistake1;
    private TreeNode mistake2;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        recoverTreeCore(root);
        if (mistake1 != null && mistake2 != null) {
            int tmp = mistake1.val;
            mistake1.val = mistake2.val;
            mistake2.val = tmp;
        }
    }

    private void recoverTreeCore(TreeNode root) {

        if (root == null) return;
        recoverTreeCore(root.left);
        if (previous != null && previous.val >= root.val) {
            if (mistake1 == null) {
                mistake1 = previous;
                mistake2 = root;
            } else mistake2 = root;
        }
        previous = root;
        recoverTreeCore(root.right);
    }
}

/**
 * Best solution: Morris traversal
 * https://blog.csdn.net/shelly_Chestnut/article/details/85234702
 */
class Solution2 {

    TreeNode previous = null;
    TreeNode mistake1 = null;
    TreeNode mistake2 = null;

    public void recoverTree(TreeNode root) {
        TreeNode current = root;
        previous = new TreeNode(Integer.MIN_VALUE);
        while (current != null) {
            if (current.left == null) {
                if (mistake1 == null && previous.val > current.val) {
                    mistake1 = previous;
                }
                if (mistake1 != null && previous.val > current.val) {
                    mistake2 = current;
                }
                previous = current;
                current = current.right;
            } else {
                TreeNode preNode = findPreNode(current);
                if (preNode.right == current) {
                    preNode.right = null;
                    if (mistake1 == null && previous.val > current.val) {
                        mistake1 = previous;
                    }
                    if (mistake1 != null && previous.val > current.val) {
                        mistake2 = current;
                    }
                    previous = current;
                    current = current.right;
                } else {
                    preNode.right = current;
                    current = current.left;
                }
            }
        }
        int temp = mistake1.val;
        mistake1.val = mistake2.val;
        mistake2.val = temp;
    }

    private TreeNode findPreNode(TreeNode root) {
        if (root == null || root.left == null) return null;
        TreeNode current = root.left;
        while (current.right != null && current.right != root) {
            current = current.right;
        }
        return current;
    }
}

class Solution3 {

    private TreeNode previous = null;
    private TreeNode mistake1 = null;
    private TreeNode mistake2 = null;

    public void recoverTree(TreeNode root) {
        TreeNode current = root;
        previous = new TreeNode(Integer.MIN_VALUE);
        while (current != null) {
            if (current.left == null) {
                if (mistake1 == null && previous.val > current.val) {
                    mistake1 = previous;
                }
                if (mistake1 != null && previous.val > current.val) {
                    mistake2 = current;
                }
                previous = current;
                current = current.right;
            } else {
                TreeNode tmp = findPreNode(current);
                if (tmp.right == null) {    // 第一次遍历到，搭桥
                    tmp.right = current;
                    current = current.left;
                } else {                    // 第二次遍历到，拆桥
                    tmp.right = null;
                    if (mistake1 == null && previous.val > current.val) {
                        mistake1 = previous;
                    }
                    if (mistake1 != null && previous.val > current.val) {
                        mistake2 = current;
                    }
                    previous = current;
                    current = current.right;
                }
            }
        }
        if (mistake1 != null && mistake2 != null) {
            int tmp = mistake1.val;
            mistake1.val = mistake2.val;
            mistake2.val = tmp;
        }
    }

    private TreeNode findPreNode(TreeNode root) {
        if (root == null || root.left == null) return null;
        TreeNode current = root.left;
        while (current.right != null && current.right != root) {
            current = current.right;
        }
        return current;
    }
}