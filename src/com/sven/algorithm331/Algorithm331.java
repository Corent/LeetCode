package com.sven.algorithm331;

import java.util.LinkedList;

public class Algorithm331 {
}

/**
 * 方法一：栈
 * https://www.jianshu.com/p/1e1985b9c318
 */
class Solution {

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.isEmpty()) return false;
        int n = preorder.length();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (preorder.charAt(i) == ',') continue;
            while (preorder.charAt(i) == '#' && !stack.isEmpty() && stack.getLast() == '#') {
                stack.pollLast();
                if (stack.isEmpty()) return false;
                stack.pollLast();
            }
            // 多位数
            while (preorder.charAt(i) >= '0' && preorder.charAt(i) <= '9' && i + 1 < n
                    && preorder.charAt(i + 1) >= '0' && preorder.charAt(i + 1) <= '9') i++;
            stack.addLast(preorder.charAt(i));
        }
        return stack.size() == 1 && stack.getLast() == '#';
    }
}

/**
 * 方法二：入度 = 出度，diff = outdegree - indegree
 * https://www.jianshu.com/p/1e1985b9c318
 */
class Solution2 {

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.isEmpty()) return false;
        int n = preorder.length();
        int diff = 1;
        for (int i = 0; i < n; i++) {
            if (preorder.charAt(i) == ',') continue;
            if (--diff < 0) return false;
            if (preorder.charAt(i) != '#') {
                diff += 2;
                while (i < n && preorder.charAt(i) >= '0' && preorder.charAt(i) <= '9') i++;
                i--;
            }
        }
        return diff == 0;
    }
}

/**
 * 递归，超时
 */
class Solution3 {

    private String[] nodes;
    private Boolean[][] dp;

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.isEmpty()) return false;
        nodes = preorder.split(",");
        dp = new Boolean[nodes.length][nodes.length];
        return isValidSerializationCore(0, nodes.length - 1);
    }

    private boolean isValidSerializationCore(int s, int e) {
        if (s > e) return false;
        if (s == e) dp[s][e] = nodes[s].equals("#");
        else if (((e - s) & 1) == 1 || nodes[s].equals("#")) dp[s][e] = false;
        if (dp[s][e] != null) return dp[s][e];
        dp[s][e] = false;
        for (int i = 1; s + i < e; i += 2) {
            if (nodes[s + i].equals("#") && isValidSerializationCore(s + 1, s + i) && isValidSerializationCore(s + i + 1, e)) {
                dp[s][e] = true;
                break;
            }
        }
        return dp[s][e];
    }
}