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

        int n = beginWord.length(), ans = 1;
        Queue<String> queue = new LinkedList<String>() {{ add(beginWord); }};
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        wordSet.remove(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int cnt = 0; cnt < size; cnt++) {
                String word = queue.poll();
                char[] chs = word.toCharArray();
                for (int j = 0; j < n; j++) {
                    char oldCh = chs[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == oldCh) continue;
                        chs[j] = c;
                        String tmp = new String(chs);
                        if (tmp.equals(endWord)) return ans + 1;
                        if (wordSet.contains(tmp)) {
                            queue.add(tmp);
                            wordSet.remove(tmp);
                        }
                    }
                    chs[j] = oldCh;
                }
            }
            ans++;
        }
        return 0;
    }
}