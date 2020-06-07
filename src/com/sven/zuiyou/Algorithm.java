package com.sven.zuiyou;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {
}

class Node {
    int val;
    Node left;
    Node right;
    public Node(int val) { this.val = val; }
}

class Solution {

    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findPaths(Node root, int target) {
        if (root == null) return ans;
        findPathsCore(root, target);
        return ans;
    }

    private void findPathsCore(Node node, int target) {
        if (node == null) return;
        if (node.val == target && node.left == null && node.right == null) {
            path.add(node.val);
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        if (node.left != null) {
            path.add(node.val);
            findPaths(node.left, target - node.val);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            path.add(node.val);
            findPaths(node.right, target - node.val);
            path.remove(path.size() - 1);
        }
    }
}