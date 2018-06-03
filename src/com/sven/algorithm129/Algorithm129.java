package com.sven.algorithm129;

import java.util.ArrayList;
import java.util.List;

public class Algorithm129 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private int ans = 0;

    private List<Integer> nums = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        if (root == null) return ans;
        sumNumbersCore(root);
        return ans;
    }

    private void sumNumbersCore(TreeNode root) {
        if (root == null) return;
        nums.add(root.val);
        if (root.left == null && root.right == null) {
            ans += Integer.valueOf(nums.stream().map(String::valueOf).reduce("", (a, b) -> a + "" + b));
        } else {
            sumNumbersCore(root.left);
            sumNumbersCore(root.right);
        }
        nums.remove(nums.size() - 1);
    }
}