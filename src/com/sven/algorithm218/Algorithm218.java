package com.sven.algorithm218;

import java.util.*;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/10
 */
public class Algorithm218 {
}

/**
 * https://www.jianshu.com/p/ef44e79462e8
 */
class Solution {
    private class Edge {
        int height;
        int x;
        boolean isStart;

        Edge(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
    }


    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ret = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return ret;
        }

        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < buildings.length; i++) {
            edges.add(new Edge(buildings[i][0], buildings[i][2], true));
            edges.add(new Edge(buildings[i][1], buildings[i][2], false));
        }

        Collections.sort(edges, new Comparator<Edge>() {
            public int compare(Edge e1, Edge e2) {
                if (e1.x != e2.x) {
                    return e1.x - e2.x;
                }
                else if (e1.isStart && e2.isStart) {
                    return e2.height - e1.height;
                }
                else if (!e1.isStart && !e2.isStart) {
                    return e1.height - e2.height;
                }
                else {
                    return e1.isStart ? -1 : 1;
                }
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                return e2.compareTo(e1);
            }
        });

        for (Edge edge : edges) {
            if (edge.isStart) {
                if (pq.isEmpty() || edge.height > pq.peek()) {
                    ret.add(new int[]{edge.x, edge.height});
                }
                pq.offer(edge.height);
            }
            else {
                pq.remove(edge.height);
                if (pq.isEmpty()) {
                    ret.add(new int[]{edge.x, 0});
                }
                else if (edge.height > pq.peek()) {
                    ret.add(new int[]{edge.x, pq.peek()});
                }
            }
        }

        return ret;
    }
}