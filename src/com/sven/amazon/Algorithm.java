package com.sven.amazon;

import java.util.*;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/5
 */
public class Algorithm {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public List<String> findTopKFreq(List<String> words, int k) {
        if (words == null || words.size() == 0 || k <= 0) return new ArrayList<String>();

        List<String> ans = new ArrayList<String>(k);

        //统计词频
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s: words) {
            int cnt = map.containsKey(s)? map.get(s): 0;
            map.put(s, cnt + 1);
        }

        //小根堆
        PriorityQueue<WordCnt> heap = new PriorityQueue<WordCnt>(new Comparator<WordCnt>() {

            @Override
            public int compare(WordCnt o1, WordCnt o2) {
                return o1.cnt - o2.cnt;
            }
        });

        //根据词频进行堆排序
        for (Map.Entry<String, Integer> e: map.entrySet()) {
            WordCnt wordCnt = new WordCnt(e.getKey(), e.getValue());
            if (heap.size() < k) heap.add(wordCnt);
            else {
                if (wordCnt.cnt > heap.peek().cnt) {
                    heap.poll();
                    heap.add(wordCnt);
                }
            }
        }

        //清空堆
        while (heap.isEmpty()) {
            ans.add(heap.poll().word);
        }

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

    public String translate(Integer num) {

        StringBuilder builder = new StringBuilder();
        int level = 0;
        while (num > 0) {
            int n = num % 10000; //3456
            num /= 10000;
            builder.append(hanzi[level]);
            int indent = 0;
            while (n > 0) {    //1. 六十五百四千三 2. 六十五百四千三万十二一
                builder.append(hanzi[indent]).append(shuzi[n % 10]); // 1. n=345 builder="六" 2. n=34 bu
                n /= 10;
                indent++; //1. 1
            }
            level = ++level % 5;
        }

        return builder.reverse().toString();
    }

    private static String[] shuzi = new String[] {
            "零", "一", "二", "三", "四", "五", "六", "七", "八", "九"
    };

    private static String[] hanzi = new String[] {
            "", "十", "百", "千", "万"
    };
}

/*12
3456

file words "abc bcd efg abc"
Top 10
abc 2
bcd 1
...*/
