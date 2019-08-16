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