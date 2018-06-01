package com.sven.algorithm692;

import javax.sql.rowset.serial.SerialStruct;
import java.util.*;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/1
 */
public class Algorithm692 {

    public static void main(String[] args) {

        String[] words = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> ans = new Solution().topKFrequent(words, 3);
        for (String s: ans) {
            System.out.print(s + " ");
        }
    }
}

class Solution {

    public List<String> topKFrequent(String[] words, int k) {

        if (words == null || words.length == 0) return new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (String w: words) {
            int cnt = map.containsKey(w)? map.get(w): 0;
            map.put(w, cnt + 1);
        }

        PriorityQueue<WordCnt> que = new PriorityQueue<WordCnt>(new Comparator<WordCnt>() {
            @Override
            public int compare(WordCnt o1, WordCnt o2) {
                int ans = o1.cnt - o2.cnt;
                return ans == 0? o2.word.compareTo(o1.word): ans;
            }
        });
        for (Map.Entry<String, Integer> e: map.entrySet()) {
            WordCnt wordCnt = new WordCnt(e.getKey(), e.getValue());
            if (que.size() < k) {
                que.add(wordCnt);
                continue;
            }
            if (que.peek().cnt > wordCnt.cnt) continue;
            if (que.peek().cnt == wordCnt.cnt && que.peek().word.compareTo(wordCnt.word) < 0) continue;
            que.poll();
            que.add(wordCnt);
        }

        Stack<String> stack = new Stack<>();
        List<String> ans = new ArrayList<>(k);
        while (!que.isEmpty()) { stack.push(que.poll().word); }
        while (!stack.isEmpty()) { ans.add(stack.pop()); }
        return ans;
    }

    class WordCnt {

        public String word;
        public Integer cnt;

        public WordCnt(String word, Integer cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
}