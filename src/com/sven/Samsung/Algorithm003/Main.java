package com.sven.Samsung.Algorithm003;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] line1 = new int[] { 9, 9 };
        int[] line2 = new int[] { 4, 1, 1, 2, 2, 3, 2, 7, 5, 6, 7, 6, 1, 5, 8, 5, 8, 9 };

        int[] rudu = new int[line1[0]];
        Set<Integer>[] fathers = new Set[line1[0]];
        for (int i = 0; i < line1[0]; i++) {
            fathers[i] = new HashSet<>();
        }

        for (int i = 0; i < line1[1]; i++) {
            int from = line2[2 * i];
            int to = line2[2 * i + 1];
            rudu[to - 1]++;
            fathers[to - 1].add(from);
        }

        boolean[] visited = new boolean[line1[0]];
        for (int j = 0; j < line1[0]; j++) {
            int idx = 0;
            for (int i = 0; i < line1[0]; i++) {
                if (rudu[i] == 0 && !visited[i]){
                    visited[i] = true;
                    idx = i + 1;
                    System.out.print(idx + " ");
                    break;
                }
            }
            for (int i = 0; i < line1[0]; i++) {
                if (!visited[i] && fathers[i].contains(idx)) {
                    rudu[i]--;
                    fathers[i].remove(idx);
                }
            }
        }
        System.out.println();
    }
}
