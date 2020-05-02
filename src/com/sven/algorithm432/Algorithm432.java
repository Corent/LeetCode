package com.sven.algorithm432;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Algorithm432 {
}

class DListNode {
    public int value;
    public HashSet<String> keySet;
    public DListNode prev;
    public DListNode next;

    DListNode() {
        keySet = new HashSet<>();
    }

}

/**
 * https://blog.csdn.net/u014031563/article/details/88390597
 */
class AllOne {

    private Map<String, Integer> keyMap = new HashMap<>();
    private Map<Integer, DListNode> valueMap = new HashMap<>();
    private DListNode head, tail;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Insert new node in the order list.
     */
    private void insertNode(String key, int curvalue, int dir) {
        DListNode newNode = new DListNode();
        valueMap.put(curvalue + dir, newNode);
        newNode.keySet.add(key);
        if (curvalue == 0) {
            newNode.next = head.next;
            head.next.prev = newNode;
            newNode.prev = head;
            head.next = newNode;
            return;
        }

        DListNode curNode = valueMap.get(curvalue);
        if (dir == 1) {
            newNode.next = curNode.next;
            curNode.next.prev = newNode;
            newNode.prev = curNode;
            curNode.next = newNode;
        } else if (dir == -1) {
            newNode.prev = curNode.prev;
            newNode.next = curNode;
            curNode.prev.next = newNode;
            curNode.prev = newNode;
        }
    }

    /**
     * Remove the empty node of the order list.
     */
    private void removeNode(int curvalue) {
        DListNode curNode = valueMap.get(curvalue);
        if (curNode.keySet.isEmpty()) {
            valueMap.remove(curvalue);
            curNode.next.prev = curNode.prev;
            curNode.prev.next = curNode.next;
            curNode.next = null;
            curNode.prev = null;
        }
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (keyMap.containsKey(key)) {
            int curvalue = keyMap.get(key);
            valueMap.get(curvalue).keySet.remove(key);
            keyMap.replace(key, curvalue + 1);
            if (valueMap.containsKey(curvalue + 1)) {
                valueMap.get(curvalue + 1).keySet.add(key);
            } else {
                insertNode(key, curvalue, 1);
            }
            removeNode(curvalue);
        } else {
            keyMap.put(key, 1);
            if (valueMap.containsKey(1)) {
                valueMap.get(1).keySet.add(key);
            } else {
                insertNode(key, 0, 1);
            }
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (keyMap.containsKey(key)) {
            int curvalue = keyMap.get(key);
            DListNode curNode = valueMap.get(curvalue);
            curNode.keySet.remove(key);
            if (curvalue == 1) {
                keyMap.remove(key);
                removeNode(curvalue);
                return;
            }
            keyMap.replace(key, curvalue - 1);
            if (valueMap.containsKey(curvalue - 1)) {
                valueMap.get(curvalue - 1).keySet.add(key);
            } else {
                insertNode(key, curvalue, -1);
            }
            removeNode(curvalue);
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return (tail.prev == head) ? "" : tail.prev.keySet.iterator().next();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return (head.next == tail) ? "" : head.next.keySet.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */