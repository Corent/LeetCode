package com.sven.algorithm316;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 贪心算法
 * https://www.cnblogs.com/co0oder/p/5352698.html
 * https://blog.csdn.net/qq_32805671/article/details/86606946
 * https://blog.csdn.net/Viscu/article/details/82564386
 *
 * 栈
 * https://blog.csdn.net/fuxuemingzhu/article/details/86063211
 */
public class Algorithm316 {
    public String removeDuplicateLetters(String s) {
        int[] chCnt = new int[26];
        char[] chs = s.toCharArray();
        boolean[] visited = new boolean[26];
        for (char ch: chs) chCnt[ch - 'a']++;
        LinkedList<Character> list = new LinkedList<>();
        for (char ch: chs) {
            int idx = ch - 'a';
            chCnt[idx]--;
            if (visited[idx]) continue;
            while (!list.isEmpty() && chCnt[list.getLast() - 'a'] > 0 && ch < list.getLast()) {
                visited[list.pollLast() - 'a'] = false;
            }
            list.addLast(ch);
            visited[idx] = true;
        }
        return list.stream().map(String::valueOf)
                .reduce("", (s1, s2) -> s1 + s2);
    }
}
