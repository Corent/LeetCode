package com.sven.algorithm094;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/22
 */
public class Algorithm094 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 递归法，EZ
 */
class Solution {

    private List<Integer> ans;

    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        inorderTraversalCore(root);
        return ans;
    }

    private void inorderTraversalCore(TreeNode node) {
        if (node == null) return;
        inorderTraversalCore(node.left);
        ans.add(node.val);
        inorderTraversalCore(node.right);
    }
}

/**
 * Morris Traversal
 * 参考Algorithm099，空间复杂度O(0)
 */
class Solution2 {

    private List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                ans.add(current.val);
                current = current.right;
            } else {
                TreeNode tmp = findPreNode(current);
                if (tmp.right == null) {    // 第一次遍历到，搭桥
                    tmp.right = current;
                    current = current.left;
                } else {                    // 第二次遍历到，拆桥
                    tmp.right = null;
                    ans.add(current.val);
                    current = current.right;
                }
            }
        }
        return ans;
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