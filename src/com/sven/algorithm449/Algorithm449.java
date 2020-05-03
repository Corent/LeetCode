package com.sven.algorithm449;

public class Algorithm449 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 前序遍历，懒得写
 * https://www.cnblogs.com/twoheads/p/11706395.html
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.substring(0, builder.length() - 1);
    }

    private void serialize(TreeNode root, StringBuilder builder) {
        if (root == null) return;
        builder.append(root.val).append(",");
        serialize(root.left, builder);
        serialize(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        return deserialize(arr, 0, arr.length - 1);
    }

    private TreeNode deserialize(String[] arr, int lo, int hi) {
        if (lo > hi) return null;
        TreeNode root = new TreeNode(Integer.valueOf(arr[lo]));
        //找到第一个比首元素大的元素位置，这个位置把数组分割为左右子树
        int index = hi + 1;
        for (int i = lo + 1; i <= hi; i++) {
            if (Integer.valueOf(arr[i]) > root.val) {
                index = i;
                break;
            }
        }
        //递归构建子树
        root.left = deserialize(arr, lo + 1, index - 1);
        root.right = deserialize(arr, index, hi);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));