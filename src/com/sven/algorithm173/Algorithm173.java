package com.sven.algorithm173;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/8
 */
public class Algorithm173 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * No, O(N) memory solution
 */
class BSTIterator {

    private int idx = -1;
    private List<Integer> nums = new ArrayList<>();

    private void init(TreeNode root) {
        if (root == null) return;
        init(root.left);
        nums.add(root.val);
        init(root.right);
    }

    public BSTIterator(TreeNode root) {
        init(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (idx + 1) < nums.size();
    }

    /** @return the next smallest number */
    public int next() {
        return nums.get(++idx);
    }
}

/**
 * https://blog.csdn.net/wen1158646729/article/details/47748649
 */

class BSTIterator2 {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator2(TreeNode root) {

        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode minCurrent = stack.pop();
        if(minCurrent.right != null){
            TreeNode rightNode = minCurrent.right;
            while(rightNode != null){
                stack.push(rightNode);
                rightNode = rightNode.left;
            }
        }

        return minCurrent.val;
    }
}