package com.sven.algorithm212;

import java.util.*;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/10
 */
public class Algorithm212 {

    public static void main(String[] args) {
        char[][] board = new char[1][2];
        board[0][0] = board[0][1] = 'a';
        String[] words = new String[] { "a" };
        List<String> ans = new Solution().findWords(board, words);
        ans.forEach(System.out::println);
    }
}

class Solution {

    private int m;
    private int n;
    private char[][] board;
    private List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        Map<Character, List<String>> map = new HashMap<>();
        Arrays.stream(words).distinct().forEach(word -> {
            char c = word.charAt(0);
            List<String> list = map.containsKey(c)? map.get(c): new ArrayList<>();
            list.add(word);
            map.put(c, list);
        });

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map.containsKey(board[i][j])) {
                    List<String> list = map.get(board[i][j]);
                    List<String> tmp = new ArrayList<>(list.size());
                    for (String s: list) {
                        if (find(i, j, s, 0)) {
                            ans.add(s);
                            tmp.add(s);
                        }
                    }
                    list.removeAll(tmp);
                }
            }
        }

        return ans;
    }

    private boolean find(int i, int j, String word, int start) {

        if (start == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || word.charAt(start) != board[i][j]) return false;

        board[i][j] = '#';
        boolean ans = find(i - 1, j, word, start + 1)
                || find(i + 1, j, word, start + 1)
                || find(i, j - 1, word, start + 1)
                || find(i, j + 1, word, start + 1);
        board[i][j] = word.charAt(start);
        return ans;
    }
}