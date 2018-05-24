package com.sven.algorithm109;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/24
 */
public class Algorithm109 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private Integer[] nums;

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        if (list.isEmpty()) return null;
        nums = new Integer[list.size()];
        nums = list.toArray(nums);
        return sortedArrayToBST(0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int from, int to) {
        if (!(from >= 0 && from <= to && to < nums.length)) return null;
        int mid = (from + to + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(from, mid - 1);
        root.right = sortedArrayToBST(mid + 1, to);
        return root;
    }
}