package com.sven.algorithm1024;

import java.util.Arrays;
import java.util.Comparator;

public class Algorithm1024 {
}

class Solution {

    public int videoStitching(int[][] clips, int T) {
        if (clips == null || clips.length == 0) return -1;
        Arrays.sort(clips, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        if (clips[0][0] != 0) return -1;

        int len = clips.length, cnt = 0;
        int maxEnd = 0;   //记录每次找到的最长片段的end值，下一次要找的片段需要 start <= maxEnd && maxEnd < end
        int curIndex = 0;   //防止重复遍历之前用过的片段
        while (maxEnd < T) {
            int end = 0;
            for (int i = curIndex; i < len; i++) {
                if (clips[i][0] <= maxEnd && clips[i][1] > maxEnd) {
                    end = Math.max(end, clips[i][1]);
                    curIndex = i;
                }
            }
            if (end == 0) return -1;  //说明该次查找拼接不上上一次的片段，直接返回-1
            cnt++;
            maxEnd = end;
        }
        return cnt;
    }

    public int test(int[][] clips, int T) {

        if (null == clips || clips.length == 0) {
            return -1;
        }
        // 排序
        Arrays.sort(clips, Comparator.comparingInt(o -> o[0]));
        if (clips[0][0] != 0) {
            return -1;
        }
        int len = clips.length;
        int maxEnd = 0;   //记录每次找到的最长片段的end值，下一次要找的片段需要 start <= maxEnd && maxEnd < end
        int count = 0;
        int curIndex = 0;   //防止重复遍历之前用过的片段
        while (maxEnd < T) {
            int end = 0;
            for (int i = curIndex; i < len; i++) {
                if (clips[i][0] <= maxEnd && clips[i][1] > maxEnd) {
                    end = Math.max(end, clips[i][1]);
                    curIndex = i;
                }
            }
            if (end == 0) {  //说明该次查找拼接不上上一次的片段，直接返回-1
                return -1;
            }
            count++;
            maxEnd = end;
        }
        return count;
    }
}