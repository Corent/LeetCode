package com.sven.algorithm363;

import java.util.TreeSet;

public class Algorithm363 {
}

/**
 * 暴力法
 * https://blog.csdn.net/JackZhang_123/article/details/78173380
 */
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length <= 0) return 0;

        int[][] sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++)
            for (int j = 1; j <= matrix[0].length; j++)
                sum[i][j] = matrix[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                for (int g = 0; g < i; g++) {
                    for (int h = 0; h < j; h++) {
                        int one = sum[i][j] - (sum[i][h] + sum[g][j] - sum[g][h]);
                        if (one <= k) max = Math.max(max, one);
                    }
                }
            }
        }
        return max;
    }
}

/**
 * https://blog.csdn.net/kexinxin1/article/details/93015711
 */
class Solution2 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        if (row == 0) return 0;

        int ans = Integer.MIN_VALUE;
        int m = Math.min(row, col), n = Math.max(row, col);

        for (int i = 0; i < m; i++) {   //  找从第i行开始一直到第0行这i+1行的可能组成的矩形长度
            int[] sums = new int[n];    //  这个数组是为了保存每一列上第j行到第i行的和
            for (int j = i; j >= 0; j--) {
                TreeSet<Integer> set = new TreeSet<>(); //  用来保存当前高度下，长度为从0开始到s位置的矩形的结果。理解set的含义是解决此题的关键。
                set.add(0);
                int sum = 0;
                for (int s = 0; s < n; s++) {
                    sums[s] += col <= row ? matrix[s][j] : matrix[j][s];
                    sum += sums[s];
                    /* 因为要满足 (sum-set中的元素) <= target,
                      * 而且sum-set中的元素的值要尽可能的大，
                      * 所以也就是再求小于等于sum-target中满足条件的元素的最小的一个
                      * 正好TreeSet中提供了这个方法ceil()，可以很方便的找出这个元素
                      */
                    Integer tmp = set.ceiling(sum - k);
                    if (tmp != null) ans = Math.max(ans, sum - tmp);
                    set.add(sum);
                }
            }
        }

        return ans;
    }
}