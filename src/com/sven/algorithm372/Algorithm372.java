package com.sven.algorithm372;

public class Algorithm372 {
}

/**
 * a^b mod c = (a mod c)^b mod c
 * ab mod c = ((a mod c) * (b mod c)) mod c
 * https://blog.csdn.net/beyond702/article/details/53222077
 * https://blog.csdn.net/qq508618087/article/details/51860222
 *
 * a ^ (b[0] * 10^(n - 1) + b[1] * 10^(n - 2) + ... + b[n - 2] * 10^1 + b[n - 1] * 10^0) = a ^ ∑ b[n - i] * 10^(i - 1)
 */
class Solution {

    private int superPow(int a, int b) {
        if (b == 0) return 1;
        int ans = 1;
        while (b-- > 0) ans = (ans * a) % 1337;
        return ans;
    }

    private int superPow(int a, int[] b, int idx) {
        if (idx < 0) return 1;
        a %= 1337;
        return (superPow(superPow(a, b, idx - 1), 10) * superPow(a, b[idx])) % 1337;
    }

    public int superPow(int a, int[] b) {
        if (b == null || b.length == 0) return 0;
        return superPow(a, b, b.length - 1);
    }
}