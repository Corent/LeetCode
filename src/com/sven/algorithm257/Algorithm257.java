package com.sven.algorithm257;

import java.util.ArrayList;
import java.util.List;

public class Algorithm257 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * dfs 递归 or stack
 */

class Solution {

    private List<Integer> crt = new ArrayList<>();
    private List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return ans;
        binaryTreePathsCore(root);
        return ans;
    }

    private void binaryTreePathsCore(TreeNode node) {
        crt.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder builder = new StringBuilder();
            crt.forEach(v -> builder.append(v).append("->"));
            ans.add(builder.substring(0, builder.length() - 2));
        } else {
            if (node.left != null) binaryTreePathsCore(node.left);
            if (node.right != null) binaryTreePathsCore(node.right);
        }
        crt.remove(crt.size() - 1);
    }
}