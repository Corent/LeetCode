package com.sven.algorithm059;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 07/02/2018
 */
public class Algorithm059 {
}

/**
 * 参考Algorithm054
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        if (n <= 0) return ans;
        int xTop = 1, xBottom = n - 1, yLeft = 0, yRight = n - 1, x = 0, y = 0, xInc = 0, yInc = 1;
        for (int i = 0; i < n * n; i++) {
            ans[x][y] = i + 1;
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