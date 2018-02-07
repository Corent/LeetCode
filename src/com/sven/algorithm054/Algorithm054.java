package com.sven.algorithm054;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 29/01/2018
 */
public class Algorithm054 {
}

/**
 * 最左最右最顶最底四个边界，向右向下向左向上四种状态，切换状态时改变边界，ez
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new ArrayList<>();
        int n = matrix[0].length;
        if (n == 0) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>(m * n);
        int xTop = 1, xBottom = m - 1, yLeft = 0, yRight = n - 1, x = 0, y = 0, xInc = 0, yInc = 1;
        for (int i = 0; i < m * n; i++) {
            ans.add(matrix[x][y]);
            if (xInc == 0 && yInc == 1) { //向右
                if (y == yRight) {  //到最右
                    yRight--;
                    xInc = 1;
                    yInc = 0;
                }
            } else if (xInc == 1 && yInc == 0) {    //向下
                if (x == xBottom) { //到最底
                    xBottom--;
                    xInc = 0;
                    yInc = -1;
                }
            } else if (xInc == 0 && yInc == -1) {   //向左
                if (y == yLeft) {   //到最左
                    yLeft++;
                    xInc = -1;
                    yInc = 0;
                }
            } else if (xInc == -1 && yInc == 0) {   //向上
                if (x == xTop) {    //到最顶
                    xTop++;
                    xInc = 0;
                    yInc = 1;
                }
            }
            x += xInc;
            y += yInc;
        }
        return ans;
    }
}