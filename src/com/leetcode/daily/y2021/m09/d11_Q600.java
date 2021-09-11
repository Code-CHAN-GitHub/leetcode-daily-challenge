package com.leetcode.daily.y2021.m09;

import sun.print.resources.serviceui;

public class d11_Q600 {

    public int findIntegers(int n) {
        int[] a = new int[31];
        int[] preSum = new int[31]; 
        a[1] = preSum[1] = 1;
        for (int i = 2; i < a.length; i++) {
            a[i] = preSum[i - 2] + (1 << (i - 1));
            preSum[i] = preSum[i - 1] + a[i];
        }
        return n + 1 - dfs(n, preSum);
    }

    private int dfs(int n, int[] preSum) {
        if (n <= 2)
            return 0;
        int x = highBitIndex(n);
        int res = preSum[x - 1];
        if ((n & (1 << (x - 1))) != 0) 
            res += n - (1 << x) - (1 << (x - 1)) + 1 + (x < 2 ? 0 : preSum[x - 2]);
        else 
            res += dfs(n - (1 << x), preSum);
        return res;
    }

    private int highBitIndex(int n) {
        if (n == 0)
            return 0;
        int x = 1, t = 1;
        while(t <= n) {
            t = 1 << (++x);
        }
        return x - 1;
    }

    public static void main(String[] args) {
        int res = new d11_Q600().findIntegers(51);
        System.out.println(res);
    }
    
}