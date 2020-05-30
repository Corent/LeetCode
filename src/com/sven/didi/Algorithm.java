package com.sven.didi;

public class Algorithm {

    public static void main(String[] args) {
        System.out.println(new Solution().sqrt3(0.001));
    }
}

class Solution {

    public double sqrt3(double n) {
        if (n == 0 || n == -1 || n == 1) return n;
        boolean isPositive = true;
        if (n < 0) {
            isPositive = false;
            n = -n;
        }
        int cnt = 0;
        String s = n + "";
        if (s.contains(".") && !s.contains("e") && !s.contains("E")) {  // 123.456
            int idx = s.indexOf('.');
            int len = s.length() - idx - 1; // 7 - 3 - 1
            while (len > 0) {
                len /= 3;
                cnt++;
            }
        }
        while (n - ((int) n) != 0) {
            n *= 1000;
            cnt++;
        }
        double left = 0, right = n; //  (n / 3) ^ 3 > n -> n ^ 3 / 27 > n -> n ^ 2 > 27 -> n > (27 ^ 0.5)
        while (left < right) {
            double mid = (left + right) / 2;
            double m = mid * mid * mid;
            if (Math.abs(m - n) < Math.pow(0.1, 9)) return convert(isPositive ? mid : -mid, cnt);
            if (m > n) right = mid;
            else left = mid;
        }
        return convert(isPositive ? left : -left, cnt);
    }

    public double convert(double m, int cnt) {
        while (cnt > 0) {
            m /= 10;
            cnt--;
        }
        return m;
    }

    /*public int compare(double a, double b) {
        double diff = a > b ? a - b : b - a;
    }*/
}