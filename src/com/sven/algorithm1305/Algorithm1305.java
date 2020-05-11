package com.sven.algorithm1305;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Algorithm1305 {
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

    private Stack<TreeNode> stack1 = new Stack<>();
    private Stack<TreeNode> stack2 = new Stack<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        addMins(stack1, root1);
        addMins(stack2, root2);

        List<Integer> ans = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            Stack<TreeNode> stack = null;
            if (stack1.isEmpty()) {
                stack = stack2;
            } else if (stack2.isEmpty()) {
                stack = stack1;
            } else {
                stack = stack1.peek().val < stack2.peek().val ? stack1 : stack2;
            }
            TreeNode min = stack.pop();
            ans.add(min.val);
            addMins(stack, min.right);
        }

        return ans;
    }

    private void addMins(Stack<TreeNode> stack, TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}