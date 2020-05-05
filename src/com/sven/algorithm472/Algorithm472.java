package com.sven.algorithm472;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Algorithm472 {
}

/**
 * 字典树
 * https://blog.csdn.net/sinat_33150417/article/details/86302588
 */
class Solution {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        List<String> res = new ArrayList<>();
        for (String s : words) trie.add(s);

        for (String s : words) {
            if (trie.checkIsConcatenatedWord(s, 0, 0)) {
                res.add(s);
            }
        }

        return res;
    }

    class Trie {

        class Node {
            private boolean isWord; //表示这个节点是否一个单词的结尾
            private Map<Character, Node> next;

            public Node() { this(false);}
            public Node(boolean isWord) {
                this.isWord = isWord;
                next = new TreeMap<>();
            }
        }

        private Node root;

        public Trie() { root = new Node(); }

        public void add(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null) {
                    cur.next.put(c, new Node());
                }
                cur = cur.next.get(c);
            }
            if (!cur.isWord) {
                cur.isWord = true;
            }
        }

        //index为开始检查的起始索引 count为isWord为true的次数 即在这条路径中有几个单词
        public boolean checkIsConcatenatedWord(String word, int index, int count) {
            Node cur = root;
            for (int i = index; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null) { //如果字典树中没有c这条路径 直接返回false
                    return false;
                }
                if (cur.next.get(c).isWord) {
                    if (i == word.length() - 1) {//如果已经到达word的尾部并且word这里是单词的结果 则看计数count是否大于1
                        return count >= 1;
                    }
                    if (checkIsConcatenatedWord(word, i + 1, count + 1)) { //如果没有到达尾部 则从index+1的位置继续检查 count计数器加1
                        return true;
                    }
                }
                cur = cur.next.get(c);
            }
            return false;
        }
    }
}

/**
 * dp[i] 表示某个单词前i个字符是否可由其他单词组成
 * https://blog.csdn.net/magicbean2/article/details/78626138
 */
class Solution2 {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> hash = Arrays.stream(words).collect(Collectors.toSet());     // using hash for acceleration
        List<String> ans = new ArrayList<>();
        for (String w : words) {
            int n = w.length();
            boolean[] dp = new boolean[n + 1];       // store whether w.substr(0, i) can be formed by existing words
            dp[0] = true;                        // empty  String is always valid
            for (int i = 0; i < n; ++i) {
                if (!dp[i]) continue;                // cannot start from here

                for (int j = i + 1; j <= n; ++j) {      // check whether w.substr(i, j - i) can be concatenated from i
                    if (j - i < n && hash.contains(w.substring(i, j))) {// cannot be itself
                        dp[j] = true;
                    }
                }
                if (dp[n]) {
                    ans.add(w);
                    break;
                }
            }
        }
        return ans;
    }
}