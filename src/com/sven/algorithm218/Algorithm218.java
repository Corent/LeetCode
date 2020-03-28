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
        int x;
        int height;
        boolean isStart;

        Edge(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
    }


    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return ans;
        }

        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < buildings.length; i++) {
            edges.add(new Edge(buildings[i][0], buildings[i][2], true));
            edges.add(new Edge(buildings[i][1], buildings[i][2], false));
        }

        Collections.sort(edges, (e1, e2) -> {
            if (e1.x != e2.x) {                     //  X不相等的情况下，小的放前边
                return e1.x - e2.x;
            } else if (e1.isStart && e2.isStart) {  //  X相等，同是左边点的情况下，高的放前边
                return e2.height - e1.height;
            } else if (!e1.isStart && !e2.isStart) {//  X相等，同是右边点的情况下，低的放前边
                return e1.height - e2.height;
            } else {                                //  X相等，一左一右的情况下，左边的放前边
                return e1.isStart ? -1 : 1;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (Edge edge : edges) {
            if (edge.isStart) {
                if (queue.isEmpty() || edge.height > queue.peek()) {    //  上升过程中，当前点比此前最高点还高，找到一个key point
                    ans.add(Arrays.asList(new Integer[]{edge.x, edge.height}));
                }
                queue.offer(edge.height);
            } else {    //  下降过程
                queue.remove(edge.height);  //  移除此高度
                if (queue.isEmpty()) {  //  在地平线处产生key point
                    ans.add(Arrays.asList(new Integer[]{edge.x, 0}));
                } else if (edge.height > queue.peek()) {    //  当前是至高点，找到一个key point，不过高度是queue.peek()
                    ans.add(Arrays.asList(new Integer[]{edge.x, queue.peek()}));
                }
            }
        }

        return ans;
    }
}