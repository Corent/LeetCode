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

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        if (words == null || words.length == 0) return ans;
        for (int i = 0; i < words.length; ) {
            int sum = 0, nextSum = words[i].length();
            List<String> line = new ArrayList<>();
            boolean flag = false, addLast = false;
            while (i < words.length && nextSum <= maxWidth) {
                sum = nextSum;
                line.add(words[i]);
                addLast = true;
                if (i == words.length - 1) {
                    flag = false;
                    break;
                }
                nextSum = sum + words[++i].length() + 1;
                flag = true;
                addLast = false;
            }
            ans.add(handleLine(line, sum, maxWidth, i == words.length - 1 && addLast));
            if (!flag) i++;
        }
        return ans;
    }

    private String handleLine(List<String> line, int sum, int maxWidth, boolean isLast) {
        int specnt = maxWidth - sum, wc = line.size();
        if (wc < 2) {
            String s = wc == 0? "": line.get(0);
            for (int i = 0; s.length() < maxWidth; i++) s += ' ';
            return s;
        }
        String last = line.get(wc - 1);
        line.remove(wc - 1);
        wc--;
        int m = isLast? 0: specnt / wc;
        int n = isLast? 0: specnt - m * wc;
        String spe = "";
        for (int i = 0; i < m; i++) spe += " ";
        for (int i = 0; i < wc; i++) {
            String s = line.get(i);
            s = s + (s.length() == 0? "": " ") + spe;
            if (n > 0) {
                s += " ";
                n--;
            }
            line.set(i, s);
        }
        String ans = line.stream().reduce("", (a, b) -> a + b) + last;
        while (isLast && ans.length() < maxWidth) ans += ' ';
        return ans;
    }
}