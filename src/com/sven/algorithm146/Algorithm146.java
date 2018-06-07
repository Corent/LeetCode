package com.sven.algorithm146;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/5
 */
public class Algorithm146 {
}

class LRUCache {

    private int size;
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> hash;    //保存上一个节点

    private void moveToTail(Node prev) {
        if (prev.next == tail) return;

        Node node = prev.next;
        prev.next = node.next;
        if (node.next != null) hash.put(node.next.key, prev);
        tail.next = node;
        node.next = null;
        hash.put(node.key, tail);
        tail = node;
    }

    public LRUCache(int capacity) {
        this.head = new Node(0, 0);
        this.tail = head;
        this.capacity = capacity;
        this.size = 0;
        this.hash = new HashMap<>();
    }

    public int get(int key) {
        if (!hash.containsKey(key)) return -1;
        moveToTail(hash.get(key));
        return hash.get(key).next.value;
    }

    public void put(int key, int value) {
        if (hash.containsKey(key)) {
            hash.get(key).next.value = value;
            moveToTail(hash.get(key));
            return;
        }

        Node node = new Node(key, value);
        tail.next = node;
        hash.put(key, tail);
        tail = node;
        size++;
        if (size > capacity) {
            hash.remove(head.next.key);
            head.next = head.next.next;
            if (head.next != null) hash.put(head.next.key, head);
            size--;
        }
    }

    class Node {
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public Node() {
            this.key = 0;
            this.value = 0;
            this.next = null;
        }
    }
}