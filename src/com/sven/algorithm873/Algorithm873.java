package com.sven.algorithm873;

public class Algorithm873 {

    public static void main(String[] args) {    // 4 14 18 32 50
        System.out.println(new Solution().lenLongestFibSubseq(new int[] { 2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50 }));
    }
}

class Solution {

    private int[] A;

    public int lenLongestFibSubseq(int[] A) {
        if (A == null) return 0;
        if (A.length < 2) return A.length;
        this.A = A;
        int ans = 0;
        for (int i = 0; i + 2 < A.length; i++) {
            for (int j = i + 1; j + 1 < A.length; j++) {
                int len = 0, next = A[i] + A[j], a = i, b = j;
                if (next >= A[b + 1] && next <= A[A.length - 1]) {
                    int idxOfNext = find(next, b + 1, A.length - 1);
                    while (idxOfNext != -1) {
                        len = len == 0 ? 3 : len + 1;
                        a = b;
                        b = idxOfNext;
                        next = A[a] + A[b];
                        if (b == A.length - 1 || b + 1 < A.length && !(next >= A[b + 1] && next <= A[A.length - 1])) break;
                        idxOfNext = find(next, b + 1, A.length - 1);
                    }
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }

    private int find(int target, int left, int right) {
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (A[mid] == target) return mid;
            if (A[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return A[left] == target ? left : -1;
    }
}