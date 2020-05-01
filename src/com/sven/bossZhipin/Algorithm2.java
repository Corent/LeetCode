package com.sven.bossZhipin;

public class Algorithm2 {

    private static int preN = 1;
    private static long preVal = 1L;

    private static int[] nums = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };
    
    private static void function() {
        long ans = 0;
        for (int n: nums) {
            long val = function1(n);
            ans += val;
            preN = n;
            preVal = val;
        }
        System.out.println(ans);
    }

    private static long function1(int n) {
        if (n == preN) return preN;
        return n * function1(n - 1);
    }

    public static void main(String[] args) {
        function();
    }
}
