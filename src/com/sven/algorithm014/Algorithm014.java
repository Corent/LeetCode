package com.sven.algorithm014;

public class Algorithm014 {
}

/**
 * 以第一个字符串为基础，从头开始比较每个位置上的字符与其他所有字符串上的字符是否相等
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || ch != strs[j].charAt(i))
                    return builder.toString();
            }
            builder.append(ch);
        }
        return builder.toString();
    }
}