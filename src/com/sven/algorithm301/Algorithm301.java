package com.sven.algorithm301;

import java.util.ArrayList;
import java.util.List;

public class Algorithm301 {

    public static void main(String[] args) {
        System.out.println(new Solution().removeInvalidParentheses("()())()"));
    }
}

/**
 * https://segmentfault.com/a/1190000013676627
 */
class Solution {

    private List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        removeInvalidParentheses(s, 0, 0, new char[] {'(', ')'});
        return ans;
    }

    private void removeInvalidParentheses(String s, int lastRemoveIdx, int lastCheckedIdx, char[] pattern) {
        for (int stack = 0, i = lastCheckedIdx; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == pattern[0]) stack++;
            if (ch == pattern[1]) stack--;
            if (stack >= 0) continue;
            for (int j = lastRemoveIdx; j <= i; j++) {
                if (s.charAt(j) == pattern[1] && (j == lastRemoveIdx || s.charAt(j - 1) != pattern[1])) { // 从lastRemoveIdx开始，递归回溯删掉各个非法括号，s.charAt(j - 1) == pattern[1]的话，删除这两个是相同的结果
                    removeInvalidParentheses(s.substring(0, j) + s.substring(j + 1), j, i, pattern);
                }
            }
            return; // 未处理完毕
        }
        String reversed = new StringBuilder((s)).reverse().toString();
        if (pattern[0] == '(') { // 处理完右括号，再处理左括号
            removeInvalidParentheses(reversed, 0, 0, new char[]{')', '('});
        } else { // 左右括号都处理完毕
            ans.add(reversed);
        }
    }
}

/**
 * https://www.bilibili.com/video/BV1VW411y7Xd
 */
class Solution2 {

    private List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            l += ch == '(' ? 1 : 0;
            if (l == 0) r += ch == ')' ? 1: 0;
            else l -= ch == ')'? 1: 0;
        }
        dfs(s, 0, l, r);
        return ans;
    }

    private void dfs(String s, int start, int l, int r) {
        if (l == 0 && r == 0) {
            if (isValid(s)) {
                ans.add(s);
                return;
            }
        }

        for (int i = start; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i != start && ch == s.charAt(i - 1)) continue;
            if (ch != '(' && ch != ')') continue;
            String next = s.substring(0, i) + s.substring(i + 1);
            if (r > 0 && ch == ')') dfs(next, i, l, r - 1);
            else if (l > 0 && ch == '(') dfs(next, i, l - 1, r);
        }
    }

    private boolean isValid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') cnt++;
            else if (ch == ')') cnt--;
            if (cnt < 0) return false;
        }
        return cnt == 0;
    }
}