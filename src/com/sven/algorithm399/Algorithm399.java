package com.sven.algorithm399;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithm399 {
}

/**
 * https://www.jianshu.com/p/e4557fb4ec95
 */
class Solution {

    private double[][] map;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new double[26][26];
        Map<String, Integer> hashMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < equations.size(); i++) {
            if (!hashMap.containsKey(equations.get(i).get(0))) {
                hashMap.put(equations.get(i).get(0), count++);
            }
            if (!hashMap.containsKey(equations.get(i).get(1))) {
                hashMap.put(equations.get(i).get(1), count++);
            }
        }

        for (int i = 0; i < equations.size(); i++) {
            int indexA = hashMap.get(equations.get(i).get(0));
            int indexB = hashMap.get(equations.get(i).get(1));
            map[indexA][indexB] = values[i];
            map[indexB][indexA] = 1 / values[i];
            map[indexA][indexA] = 1;
            map[indexB][indexB] = 1;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    for (int k = 0; k < map[0].length; k++) {
                        if (map[j][k] > 0) {
                            map[i][k] = map[i][j] * map[j][k];
                        }
                    }
                }
            }
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            if (!hashMap.containsKey(queries.get(i).get(0)) || !hashMap.containsKey(queries.get(i).get(1))) {
                result[i] = -1.0;
                continue;
            }

            int indexA = hashMap.get(queries.get(i).get(0));
            int indexB = hashMap.get(queries.get(i).get(1));

            result[i] = map[indexA][indexB] == 0 ? -1.0 : map[indexA][indexB];
        }

        return result;
    }
}