package com.sven.algorithm055;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 30/01/2018
 */
public class Algorithm055 {
}

/**
 * 参考Algorithm045
 */
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) return true;
        int farest = 0, prevFarest = 0;    //能跳到最远的位置，用于记录farest的临时变量
        for (int i = 0; i < nums.length; ) {
            if (prevFarest >= nums.length - 1) return true;   //能跳到最远的位置已经超过末位，退出
            while (i <= prevFarest) {   //遍历i到prevFarest之间的位置，更新farest
                farest = Math.max(farest, i + nums[i]);
                i++;
            }
            prevFarest = farest;
            if (i > farest) break;
        }
        return false;
    }
}