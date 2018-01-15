package com.sven.algorithm045;

public class Algorithm045 {

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[] { 2, 3, 1, 1, 4 }));
    }
}

class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int farest = 0, prevFarest = 0, jumpCnt = 0;    //能跳到最远的位置，用于记录farest的临时变量，跳数
        for (int i = 0; i < nums.length; ) {
            if (prevFarest >= nums.length - 1) break;   //能跳到最远的位置已经超过末位，退出
            while (i <= prevFarest) {   //遍历i到prevFarest之间的位置，更新farest
                farest = Math.max(farest, i + nums[i]);
                i++;
            }
            jumpCnt++;  //跳数+1
            prevFarest = farest;
        }
        return jumpCnt;
    }
}
/**
 * 超时 O(n^2)
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int minJump = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (j + nums[j] >= i)
                    minJump = Math.min(minJump, dp[j] + 1);
            }
            dp[i] = minJump;
        }
        return dp[nums.length - 1];
    }
}*/
