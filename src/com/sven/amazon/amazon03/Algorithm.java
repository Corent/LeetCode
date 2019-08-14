package com.sven.amazon.amazon03;


import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    public static void main(String[] args) {

    }
}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }
}

class PathNode {
    public Node node;
    public Integer tag;   // left: 0, right: 1 or deep

    public PathNode(Node node) {
        this.node = node;
    }

    public PathNode(Node node, int tag) {
        this.node = node;
        this.tag = tag;
    }
}

class Solution {

    private Node root;
    private Node leaf;
    private boolean done = false;
    private List<PathNode> path = new ArrayList<>();

    public Node closestLeaf(Node root, Node leaf) {
        if (root == null || leaf == null) return null;
        this.root = root;
        this.leaf = leaf;

        findPathToLeaf(root);

        Node ans = null;
        int idx = path.size() - 2, subLen = 1, minLen = Integer.MAX_VALUE;
        while (idx >= 0) {
            PathNode pathNode = path.get(idx), tmp = null;
            if (pathNode.tag == 0 && pathNode.node.right != null) {
                tmp = findMinPathToLeaf(pathNode.node.right, 0);
            } else if (pathNode.tag == 1 && pathNode.node.left != null) {
                tmp = findMinPathToLeaf(pathNode.node.left, 0);
            }
            if (tmp != null) {
                int len = subLen + 1 + tmp.tag;
                if (len < minLen) {
                    minLen = len;
                    ans = tmp.node;
                }
            }
            idx--;
            subLen++;
        }

        return ans;
    }

    private void findPathToLeaf(Node node) {
        if (done) return;
        PathNode pathNode = new PathNode(node);
        path.add(pathNode);

        if (node != null && node.left == null && node.right == null && node.value == leaf.value) {
            done = true;
            return;
        }

        if (node.left != null) {
            pathNode.tag = 0;
            findPathToLeaf(node.left);
            if (done) return;
        }

        if (node.right != null) {
            pathNode.tag = 1;
            findPathToLeaf(node.right);
            if (done) return;
        }

        path.remove(path.size() - 1);
    }

    private PathNode findMinPathToLeaf(Node root, int deep) {
        if (root == null) return new PathNode(null, Integer.MAX_VALUE);
        if (root.left == null && root.right == null) return new PathNode(root, deep);
        PathNode left = findMinPathToLeaf(root.left, deep + 1);
        PathNode right = findMinPathToLeaf(root.right, deep + 1);
        return left.tag < right.tag? left: right;
    }
}