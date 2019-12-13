package com.sven.algorithm855;

import java.util.HashMap;
import java.util.TreeSet;

public class Algorithm855 {
}

/**
 * TreeSet + HashMap
 * https://www.cnblogs.com/Dylan-Java-NYC/p/11857587.html
 */
class ExamRoom {

    private int N;
    private TreeSet<int[]> intervalSet;
    private HashMap<Integer, int []> sMap;
    private HashMap<Integer, int []> eMap;

    public ExamRoom(int N) {
        this.N = N;
        intervalSet = new TreeSet<>((a,b) -> {
            if(dist(b) == dist(a)){
                return a[0] - b[0];
            }

            return dist(b) - dist(a);
        });

        sMap = new HashMap<>();
        eMap = new HashMap<>();
        add(new int[]{-1, N});
    }

    public int seat() {
        int [] top = intervalSet.pollFirst();

        int pos = 0;
        if (top[0] == -1) {
            pos = 0;
        } else if (top[1] == N) {
            pos = N - 1;
        } else {
            pos = top[0] + (top[1] - top[0]) / 2;
        }

        add(new int[]{top[0], pos});
        add(new int[]{pos, top[1]});

        return pos;
    }

    public void leave(int p) {
        int[] left = eMap.get(p);
        int[] right = sMap.get(p);
        int[] merged = new int[] {left[0], right[1]};

        remove(left);
        remove(right);
        add(merged);
    }

    private int dist(int[] interval){
        if(interval[0] == -1){
            return interval[1];
        }

        if(interval[1] == N){
            return N - interval[0] - 1;
        }

        return (interval[1] - interval[0]) / 2;
    }

    private void add(int [] interval){
        intervalSet.add(interval);
        sMap.put(interval[0], interval);
        eMap.put(interval[1], interval);
    }

    private void remove(int [] interval){
        intervalSet.remove(interval);
        sMap.remove(interval[0]);
        eMap.remove(interval[1]);
    }
}