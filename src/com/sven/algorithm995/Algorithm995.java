package com.sven.algorithm995;

import java.util.LinkedList;

public class Algorithm995 {
}

/**
 * https://www.freesion.com/article/3366159815/
 */
class Solution {

    public int minKBitFlips(int[] A, int K) {
        if (A == null || A.length == 0) return -1;
        LinkedList<Integer> window = new LinkedList<>(); //  window用来存放被反转元素的下标，window的长度表示反转的次数

        int ans = 0;
        for (int i = 0; i < A.length; ++i) {
            //当下标之间的距离大于k时，需要移除队头下标了
            while (!window.isEmpty() && window.peekFirst() + K <= i) {
                window.pollFirst();
            }

            if (A[i] == window.size() % 2) {    //  当前位置的1反转奇数次为0，需要反转；当前位置的0反转偶数次还是为0，还是需要反转
                if (i + K > A.length) return -1;
                window.addLast(i);
                ans++;
            }
        }
        return ans;
    }
}