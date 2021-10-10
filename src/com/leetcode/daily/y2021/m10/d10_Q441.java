package com.leetcode.daily.y2021.m10;

class d10_Q441 {

    public int arrangeCoins(int _n) {
        long n = _n;
        long x = (int) ((Math.sqrt(8 * n + 1) - 1) / 2);
        if ((x + 1) * x > 2 * n)
            x++;
        return (int) x;
    }

    public static void main(String[] args) {
        int n = 5;
        int res = new d10_Q441().arrangeCoins(n);
        System.out.println(res);
    }

}