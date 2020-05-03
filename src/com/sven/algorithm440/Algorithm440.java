package com.sven.algorithm440;

public class Algorithm440 {
}

/**
 * 十叉树的遍历
 * https://www.jianshu.com/p/942ad26286ff
 * https://zhuanlan.zhihu.com/p/85362739
 */
class Solution {
    public int findKthNumber(int n, int k) {
        k--;
        int curr = 1;
        while (k > 0) {
            long step = calstep(n, curr, curr + 1);
            if (k < step) {//在这个范围内
                curr *= 10;//移动一层
                k--;
            } else {//移动相邻的下一个节点
                k -= step;
                curr = curr + 1;
            }

        }
        return curr;
    }

    public long calstep(int n, long n1, long n2) {
        int ans = 0;
        while (n1 <= n) {
            ans += Math.min(n + 1, n2) - n1;    //当前层的node的数量
            n1 *= 10;   //指针指向下一层的起点
            n2 *= 10;   //指针指向下一层起点
        }
        return ans;
    }
}