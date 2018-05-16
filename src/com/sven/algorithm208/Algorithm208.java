package com.sven.algorithm208;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/16
 */
public class Algorithm208 {
}

class Trie {

    private int SIZE = 26;
    private TrieNode root;//字典树的根

    Trie() { root = new TrieNode(); } //初始化字典树

    private class TrieNode { //字典树节点

        private int num;//有多少单词通过这个节点,即由根至该节点组成的字符串模式出现的次数
        private TrieNode[]  son;//所有的儿子节点
        private boolean isEnd;//是不是最后一个节点

        TrieNode() {
            num = 1;
            son = new TrieNode[SIZE];
            isEnd = false;
        }
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        if (word == null || word.length() == 0) return;
        TrieNode node = root;
        char[] letters = word.toCharArray();
        for (int i = 0, len = word.length(); i < len; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null) {
                node.son[pos] = new TrieNode();
            } else node.son[pos].num++;
            node = node.son[pos];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        if(word == null || word.length() == 0) return false;
        TrieNode node = root;
        char[] letters = word.toCharArray();
        for (int i = 0, len = word.length(); i < len; i++) {
            int pos = letters[i]-'a';
            if (node.son[pos] != null) node = node.son[pos];
            else return false;
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        if (prefix == null || prefix.length() == 0) return true;
        TrieNode node = root;
        char[] letters = prefix.toCharArray();
        for (int i = 0, len = prefix.length(); i < len; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null) return false;
            else node = node.son[pos];
        }
        return true;
    }
}