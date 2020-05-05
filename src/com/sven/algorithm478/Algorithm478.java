package com.sven.algorithm478;

public class Algorithm478 {
}

/**
 * https://www.jianshu.com/p/ba2bf153d1ad?from=singlemessage
 */
class Solution {

    private double x;
    private double y;
    private double r;

    public Solution(double radius, double x_center, double y_center) {
        this.r = radius;
        this.x = x_center;
        this.y = y_center;
    }

    public double[] randPoint() {
        double ca = (int) (Math.random() * 360);
        double cr = Math.sqrt(Math.random()) * r;
        return new double[]{x + cr * Math.cos(ca), y + cr * Math.sin(ca)};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */