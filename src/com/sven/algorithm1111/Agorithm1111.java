package com.sven.algorithm1111;

public class Agorithm1111 {
}

/**
 * https://www.cnblogs.com/izhoujie/p/12616794.html
 * 简单讲就是将()平均分成两块，最后它们的深度必都为1，题目要求返回数组形式；
 * 步骤：按顺序把第奇数个(放一起，把第偶数个(放一起，剩下的)反之分配；
 */
class Solution {

    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int index = 0;
        for (char c : seq.toCharArray()) {
            // 下面4行代码都是正确的，取任意一行即可
            ans[index++] = c == '(' ? index & 1 : 1 - (index & 1);
            // ans[index++] = c == '(' ? index & 1 : (index + 1) & 1;
  			// ans[index++] = c == '(' ? index & 1 : (index - 1) & 1;
  			// ans[index++] = (index & 1) ^ (c == '(' ? 1 : 0);
        }
        return ans;
    }
}