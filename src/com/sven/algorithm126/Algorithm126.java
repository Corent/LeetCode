package com.sven.algorithm126;

import java.util.*;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/1
 */
public class Algorithm126 {
}

class Solution {

    private List<List<String>> ans = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    private Map<String, Integer> vis = new HashMap<>();
    private Map<String, List<String>> next = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return ans;

        int n = beginWord.length();
        Queue<String> queue = new LinkedList<String>() {{ add(beginWord); }};
        vis.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            if (word.equals(endWord)) break;
            int step = vis.get(word);
            List<String> sNext = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] chs = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chs[i] = c;
                    String tmp = new String(chs);
                    if (c == word.charAt(i) || !wordSet.contains(tmp)) continue;
                    if (!vis.containsKey(tmp)) {
                        queue.add(tmp);
                        vis.put(tmp, step + 1);
                    }
                    sNext.add(tmp);
                }
            }
            next.put(word, sNext);
        }
        path.add(beginWord);
        dfsPath(beginWord, endWord);
        return ans;
    }

    private void dfsPath(String now, String end) {
        if (now.equals(end)) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (!next.containsKey(now)) return;
        List<String> list = next.get(now);
        int visn = vis.get(now);
        for (int i = 0; i < list.size(); i++) {
            if (vis.get(list.get(i)) != visn + 1) continue;
            path.add(list.get(i));
            dfsPath(list.get(i), end);
            path.remove(path.size() - 1);
        }
    }
}