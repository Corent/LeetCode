package com.sven.algorithm068;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 10/02/2018
 */
public class Algorithm068 {

    public static void main(String[] args) {
        List<String> ans = new Solution().fullJustify(new String[] { "Listen","to","many,","speak","to","a","few." }, 6);
        ans.forEach(System.out::println);
    }
}

/**
 * 贪心算法，注意边界条件：该行有没有元素是否是最后一行
 */
class Solution {

    private int maxWidth;

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        if (words == null || words.length == 0) return ans;
        this.maxWidth = maxWidth;
        int sum = 0;
        List<String> line = new ArrayList<>();
        for (int i = 0; i < words.length; ) {
            if (line.isEmpty()) {
                sum = words[i].length();
                line.add(words[i++]);
                continue;
            }
            if (sum + words[i].length() + 1 <= maxWidth) {
                sum += words[i].length() + 1;
                line.add(words[i++]);
                continue;
            }
            ans.add(handleLine(line, sum, i == words.length));
            sum = 0;
            line.clear();
        }
        if (!line.isEmpty()) {
            ans.add(handleLine(line, sum, true));
        }
        return ans;
    }

    private String handleLine(List<String> line, int sum, boolean isLastLine) {
        int speCnt = maxWidth - sum, wCnt = line.size();
        if (wCnt < 2) {
            StringBuilder builder = new StringBuilder(wCnt == 0? "": line.get(0));
            for (int i = 0; builder.length() < maxWidth; i++) builder.append(' ');
            return builder.toString();
        }
        String last = line.get(wCnt - 1);
        line.remove(wCnt-- - 1);
        int m = isLastLine? 0: speCnt / wCnt;
        int n = isLastLine? 0: speCnt % wCnt;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < m; i++) builder.append(' ');
        String spe = builder.toString();
        builder = new StringBuilder();
        for (int i = 0; i < wCnt; i++) {
            String s = line.get(i);
            builder.append(s).append(s.length() == 0 ? "" : " ").append(spe);
            if (n > 0) {
                builder.append(" ");
                n--;
            }
        }
        builder.append(last);
        while (isLastLine && builder.length() < maxWidth) builder.append(' ');
        return builder.toString();
    }
}