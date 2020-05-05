package com.sven.algorithm466;

public class Algorithm466 {
}

/**
 * https://www.cnblogs.com/grandyang/p/6149294.html
 */
class Solution {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int[] repeatCnt = new int[n1 + 1], nextIdx = new int[n1 + 1];   //  重复次数，下一次匹配开始位置
        int j = 0, cnt = 0;
        for (int k = 1; k <= n1; ++k) {
            for (int i = 0; i < s1.length(); ++i) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    ++j;
                    if (j == s2.length()) {
                        j = 0;
                        ++cnt;
                    }
                }
            }
            repeatCnt[k] = cnt;
            nextIdx[k] = j;
            for (int start = 0; start < k; ++start) {   //  判断之前是否已经有从j开始的匹配，有的话可以直接计算返回
                if (nextIdx[start] == j) {
                    int interval = k - start;
                    int repeat = (n1 - start) / interval;
                    int patternCnt = (repeatCnt[k] - repeatCnt[start]) * repeat;
                    int remainCnt = repeatCnt[start + (n1 - start) % interval];
                    return (patternCnt + remainCnt) / n2;
                }
            }
        }
        return repeatCnt[n1] / n2;
    }
}