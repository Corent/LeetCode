package com.sven.MeiJia;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Algorithm2 {

    public static void main(String[] args) {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(1);
        new MyThread(s1, s2).run();
        new MyThread(s2, s1).run();
    }

    private static boolean isCompletedBinaryTree(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode preNode = root;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (preNode == null && node != null) {
                return false;
            }
            preNode = node;
            if (node != null) {
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
        }
        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

class MyThread implements Runnable {

    private Semaphore s1;
    private Semaphore s2;

    public MyThread(Semaphore s1, Semaphore s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        try {
            s1.acquire();
            TimeUnit.SECONDS.sleep(1);
            s2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            s1.release();
            s2.release();
        }
    }
}