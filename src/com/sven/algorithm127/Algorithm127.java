package com.sven.algorithm127;

import java.util.*;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/1
 */
public class Algorithm127 {

    public static void main(String[] args) {
        System.out.println(new Solution().ladderLength("hit", "cog", Arrays.asList(new String[] { "hot","dot","dog","lot","log","cog" })));
    }
}

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int n = beginWord.length();
        Queue<String> que = new LinkedList<>();
        que.add(beginWord);
        int length = 1;
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        wordSet.remove(beginWord);

        while (!que.isEmpty()) {
            int size = que.size();
            for (int cnt = 0; cnt < size; cnt++) {
                String word = que.poll();
                char[] chs = word.toCharArray();
                for (int j = 0; j < n; j++) {
                    char oldCh = chs[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == oldCh) continue;
                        chs[j] = c;
                        String tmp = new String(chs);
                        if (tmp.equals(endWord)) return length + 1;
                        if (wordSet.contains(tmp)) {
                            que.add(tmp);
                            wordSet.remove(tmp);
                        }
                    }
                    chs[j] = oldCh;
                }
            }
            length++;
        }
        return 0;
    }
}