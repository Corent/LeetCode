package com.sven.algorithm211;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/10
 */
public class Algorithm211 {
}

class WordDictionary {

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.child[idx] == null) node.child[idx] = new TrieNode();
            node = node.child[idx];
        }
        node.isWorld = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root, 0);
    }

    private boolean search(String word, TrieNode node, int i) {
        if (i == word.length()) return node.isWorld;
        if (word.charAt(i) == '.') {
            for (int idx = 0; idx < 26; idx++) {
                if (node.child[idx] != null && search(word, node.child[idx], i + 1)) return true;
            }
            return false;
        } else return node.child[word.charAt(i) - 'a'] != null && search(word, node.child[word.charAt(i) - 'a'], i + 1);
    }

    class TrieNode {

        private boolean isWorld;
        private TrieNode[] child = new TrieNode[26];
    }
}