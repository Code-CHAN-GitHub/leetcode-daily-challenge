package com.leetcode.daily.y2021.m12;

public class d05_Q372 {
    /**
     * (a * b) % p = ((a % p) * (b % p)) % p
     */

    int m = 1337;
    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    public int dfs(int a, int[] b, int i) {
        if (i < 0) return 1;
        return (qpow(dfs(a, b, i - 1), 10) * qpow(a, b[i])) % m;
    }

    private int qpow(int x, int n) {
        if (n == 0) return 1;
        else if (n == 1) return x % m;
        int t = qpow(x, n / 2);
        int res = (t * t) % m;
        if (n % 2 != 0) res = ((x % m) * res) % m;
        return res;
    }

    public static void main(String[] args) {   
        int a = 2;
        int[] b = {1, 0};
        int res = new d05_Q372().superPow(a, b);
        System.out.println(res);
    }
}