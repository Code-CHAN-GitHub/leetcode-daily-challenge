package com.leetcode.daily.y2022.m01;

import com.leetcode.utils.myassert.AssertUtils;

public class d17_Q1220 {

    static int N = 5, mod = (int)(1e9 + 7);
    static long[][] E;
    static {
        E = new long[N][N];
        for (int i = 0; i < N; i++) E[i][i] = 1;
    }
    
    public int countVowelPermutation(int n) {
        long[][] m = {
            {0, 1, 1, 0, 1},
            {1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 1, 0}
        };
        m = martixPow(m, n - 1);
        long[][] f = martixMul(new long[][]{{1, 1, 1, 1, 1}}, m);
        long ans = 0;
        for (int i = 0; i < N; i++) ans = (ans + f[0][i]) % mod;
        return (int) ans;
    }
    
    private long[][] martixMul(long[][] m1, long[][] m2) {
        int u = m1.length, v = m1[0].length, w = m2[0].length;
        long[][] ret = new long[u][w];
        for (int i = 0; i < u; i++) {
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < v; k++) {
                    ret[i][j] = (ret[i][j] + m1[i][k] * m2[k][j]) % mod;
                }
            }
        }
        return ret;
    }
    
    private long[][] martixPow(long[][] m, int n) {
        if (n == 0) return E;
        if (n == 1) return m;
        long[][] t = martixPow(m, n / 2);
        long[][] ret = martixMul(t, t);
        if (n % 2 != 0) ret = martixMul(ret, m);
        return ret;
    }

    public static void main(String[] args) {
        int n = 5;
        int ret = new d17_Q1220().countVowelPermutation(n);
        AssertUtils.assertTrue(ret == 68);
    }
    
}