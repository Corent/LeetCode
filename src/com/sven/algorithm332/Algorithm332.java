package com.sven.algorithm332;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Algorithm332 {
}

class Solution {

    private String[] nodes;
    private int[][] matrix;
    private List<List<String>> tickets;
    private List<String> ans = null;
    private List<String> path = new ArrayList<>();
    private Map<String, Integer> nameToId = new HashMap<>();
    private Map<Integer, String> idToName = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        this.tickets = tickets;
        Set<String> nodeSet = new HashSet<>();
        tickets.forEach(ticket -> nodeSet.addAll(ticket));
        nodes = new String[nodeSet.size()];
        Arrays.sort(nodeSet.toArray(nodes));

        for (int i = 0; i < nodes.length; i++) {
            nameToId.put(nodes[i], i);
            idToName.put(i, nodes[i]);
        }

        matrix = new int[nodes.length][nodes.length];
        tickets.forEach(ticket -> {
            int x = nameToId.get(ticket.get(0));
            int y = nameToId.get(ticket.get(1));
            matrix[x][y]++;
        });

        dfs(nameToId.get("JFK"));

        return ans;
    }

    private void dfs(int idx) {
        if (ans != null) return;
        path.add(idToName.get(idx));
        if (path.size() == tickets.size() + 1) {
            ans = new ArrayList<>(path);
            return;
        };
        for (int next = 0; next < nodes.length; next++) {
            if (matrix[idx][next] > 0) {
                matrix[idx][next]--;
                dfs(next);
                matrix[idx][next]++;
            }
        }
        path.remove(path.size() - 1);
    }
}

/**
 * 优先级队列，DFS找到第一个
 * https://blog.csdn.net/qq_38595487/article/details/84479913
 */
class Solution2 {

    private List<String> list = new ArrayList<String>();
    private Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> strings: tickets) {
            if (map.containsKey(strings.get(0))) {
                map.get(strings.get(0)).add(strings.get(1));
            } else {
                PriorityQueue<String> pqt = new PriorityQueue<String>();
                pqt.add(strings.get(1));
                map.put(strings.get(0), pqt);
            }
        }

        dfs("JFK");
        Collections.reverse(list);

        return list;
    }

    private void dfs(String s) {

        if (!map.containsKey(s)){
            list.add(s);
            return;
        }

        PriorityQueue<String> pq = map.get(s);
        if (pq.size() == 0){
            list.add(s);
            return;
        }

        while (pq.size() != 0) dfs(pq.poll());
        list.add(s);    //  逆序
    }
}