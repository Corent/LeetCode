package com.sven.algorithm706;

public class Algorithm706 {
}

class MyHashMap {
    
    private int size = 100000;
    private Node[] hash;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        hash = new Node[size];
        for (int i = 0; i < hash.length; i++) {
            hash[i] = new Node(-1, -1);
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        Node p = findNode(key);

        if (p.next == null) {
            p.next = new Node(key, value);
        } else {
            p.next.val = value;
        }
    }

    private Node findNode(int key) {
        int idx = getHash(key);
        Node p = hash[idx];

        while (p.next != null && p.next.key != key) {
            p = p.next;
        }

        return p;
    }

    private int getHash(int n) {
        return n % size;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        Node p = findNode(key);

        if (p.next == null) {
            return -1;
        }

        return p.next.val;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        Node p = findNode(key);

        if (p.next == null) {
            return;
        }

        p.next = p.next.next;
    }
}

class Node {
    int key;
    int val;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}