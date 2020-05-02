package com.sven.algorithm427;

public class Algorithm427 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        };
        Node node = new Solution().construct(grid);
        System.out.println();
    }
}

// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

class Solution {

    private int[][] grid;

    public Node construct(int[][] grid) {
        this.grid = grid;
        return construct(0, 0, grid.length);
    }

    private Node construct(int x, int y, int len) {
        Node node = new Node();
        if (len == 1) {
            node.val = grid[x][y] == 1;
            node.isLeaf = true;
            return node;
        }

        len >>= 1;
        Node topLeft = construct(x, y, len);
        Node topRight = construct(x, y + len, len);
        Node bottomLeft = construct(x + len, y, len);
        Node bottomRight = construct(x + len, y + len, len);
        node.isLeaf = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                && (topLeft.val && topRight.val && bottomLeft.val && bottomRight.val
                || !topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val);
        if (node.isLeaf) node.val = topLeft.val;
        else {
            node.val = true;
            node.topLeft = topLeft;
            node.topRight = topRight;
            node.bottomLeft = bottomLeft;
            node.bottomRight = bottomRight;
        }

        return node;
    }
}