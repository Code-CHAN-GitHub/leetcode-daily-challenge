package com.leetcode.daily.y2021.m09;

/**
 * @See <a href="https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/">fei-bo-na-qi-shu-lie-lcof</a>
 */
public class d04_Offer10_1 {

    private int mod = (int) (1e9 + 7);

    public int fib(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1, c = 1;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % mod;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 100;
        int res = new d04_Offer10_1().fib(n);
        System.out.println(res);
    }
}